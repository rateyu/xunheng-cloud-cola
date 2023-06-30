package com.xunheng.auth.domain.login.ability.impl;

import cn.dev33.satoken.session.SaSessionCustomUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.xunheng.auth.domain.config.properties.SaTokenProperties;
import com.xunheng.auth.domain.login.gateway.LoginGateway;
import com.xunheng.auth.domain.login.ability.LoginDomainService;
import com.xunheng.auth.domain.login.model.LoginEntity;
import com.xunheng.base.exception.CaptchaErrorException;
import com.xunheng.base.exception.LoginFailException;
import com.xunheng.base.vo.system.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class LoginDomainServiceImpl implements LoginDomainService {

    @Resource
    private LoginGateway loginGateway;

    @Resource
    private SaTokenProperties tokenProperties;

    /**
     * 校验验证码
     * @param entity 登陆实体
     */
    private void checkCaptcha(LoginEntity entity) {
        /*redis加载缓存的验证码*/
        String redisCode = loginGateway.getCaptchaCodeById(entity.getCaptcha().getCaptchaId());
        if(StrUtil.isBlank(redisCode))throw new CaptchaErrorException("验证码已过期，请重新获取");
        /*验证码错误*/
        if(!redisCode.equalsIgnoreCase(entity.getCaptcha().getVerifyCode().getCode())) {
            log.info("验证码错误：code:"+ entity.getCaptcha().getVerifyCode().getCode() +"，redisCode:"+redisCode);
            throw new LoginFailException("图形验证码输入错误");
        }
        /*验证通过 清除验证码缓存*/
        loginGateway.removeCaptcha(entity.getCaptcha().getCaptchaId());
    }

    /**
     * 校验用户名是否被锁定
     * @param entity 登录实体
     */
    private void checkLockStatus(LoginEntity entity) {
        /*redis获取登陆锁定剩余时间*/
        Long timeRest = loginGateway.getLockTimeRest(entity.getUsername());
        if(timeRest > 0){
            throw new LoginFailException("登录错误次数超过限制，请"+timeRest+"分钟后再试");
        }
    }

    /**
     * 登录失败的处理
     * @param entity 登录实体
     */
    private void handleLoginFail(LoginEntity entity) {
        /*记录错误次数 拿到剩余可登陆次数 判断次数是否超限 是则锁定账户*/
        int restLoginTime = recordLoginTime(entity.getUsername());
        /*根据情况抛出对应异常*/
        if(restLoginTime<=3&&restLoginTime>0){
            throw new LoginFailException("用户名或密码错误，还有"+restLoginTime+"次尝试机会");
        } else if(restLoginTime<=0) {
            throw new LoginFailException("登录错误次数超过限制，请"+tokenProperties.getLoginAfterTime()+"分钟后再试");
        } else {
            throw new LoginFailException("用户名或密码错误");
        }
    }

    @Override
    public String saLogin(LoginEntity entity) {
        /*SA登录 保存session信息*/
        String token = loginGateway.saLogin(entity);
        /*刷新userDetail缓存*/
        loginGateway.reloadUserDetailCache(entity.getId());
        /*清除错误登录数据*/
        loginGateway.removeLoginFailCache(entity.getUsername());
        return token;
    }

    @Override
    public void saLogout(String id) {
        /*sa登出 登出sa会清除用户session*/
        StpUtil.logout();
        /*删除权限缓存*/
        SaSessionCustomUtil.deleteSessionById("permission:" + id);
    }

    @Override
    public void checkValidation(LoginEntity login) {
        /*验证码验证 */
        checkCaptcha(login);
        /*账户是否被锁定验证 */
       checkLockStatus(login);
        /*获取账号信息 通过gateway调用用户领域 获取登录相关的用户信息 */
        UserLoginVO userLogin = loginGateway.getUserLoginInfo(login);
        /*账号是否存在验证*/
        if(userLogin == null)handleLoginFail(login);
        /*密码验证*/
        if(!login.checkPassword(userLogin.getPassword()))handleLoginFail(login);
        /*所属租户是否过期验证*/
        loginGateway.checkTenantExpire(userLogin.getTenantId());
    }

    /**
     * 记录用户登陆错误次数
     * @param username 用户名
     * @return 剩余可登录次数
     */
    private int recordLoginTime(String username){
        /*获取已登录错误次数*/
        Integer loginFailTime = loginGateway.getLoginFailTimes(username);
        /*更新错误次数*/
        loginGateway.updateLoginFailTimes(username,++loginFailTime);
        /*超过错误最大次数 锁定账户*/
        if(loginFailTime>=tokenProperties.getLoginTimeLimit()){
            loginGateway.lockAccount(username);
        }
        log.info("用户"+username+"登录失败，还有"+(tokenProperties.getLoginTimeLimit() - loginFailTime)+"次机会");
        return tokenProperties.getLoginTimeLimit() - loginFailTime;
    }
}
