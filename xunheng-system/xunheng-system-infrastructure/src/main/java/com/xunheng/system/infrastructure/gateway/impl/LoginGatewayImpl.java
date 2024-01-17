package com.xunheng.system.infrastructure.gateway.impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.base.utils.DateUtil;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.log.client.api.BaseFeignLogService;
import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.system.client.dto.AuthLoginCmd;
import com.xunheng.system.domain.login.gateway.LoginGateway;
import com.xunheng.system.domain.login.model.CaptchaEntity;
import com.xunheng.system.domain.login.model.LoginEntity;
import com.xunheng.system.domain.login.properties.SaTokenProperties;
import com.xunheng.system.domain.user.gateway.UserGateway;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @program: xunheng-cloud-cola
 * @description: 登录基础层网关实现类
 * @author: hhqkkr
 * @date: 2023/6/29 13:52
 */
@Component
public class LoginGatewayImpl implements LoginGateway {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SaTokenProperties tokenProperties;

    @Resource
    private BaseFeignLogService baseFeignLogService;

    @Resource
    private UserGateway userGateway;

    @Override
    public void cacheCaptcha(CaptchaEntity entity) {
        /*redis缓存验证码*/
        stringRedisTemplate.opsForValue().set(entity.getCaptchaId(),entity.getVerifyCode().getCode(),2L,TimeUnit.MINUTES);
    }

    @Override
    public void removeCaptcha(String captchaId) {
        /*redis删除验证码缓存*/
        stringRedisTemplate.delete(captchaId);
    }

    @Override
    public String getCaptchaCodeById(String captchaId) {
        /*redis获取验证码*/
        return stringRedisTemplate.opsForValue().get(captchaId);
    }

    @Override
    public Long getLockTimeRest(String username) {
        String flagKey = "loginFailFlag:"+username;
        /*拿到锁定标志*/
        String value = stringRedisTemplate.opsForValue().get(flagKey);
        /*拿到剩余时间*/
        long timeRest = stringRedisTemplate.getExpire(flagKey, TimeUnit.MINUTES);
        if(timeRest != 0 && StrUtil.isNotBlank(value)){
           return timeRest;
        }
        return -1L;
    }

    @Override
    public Integer getLoginFailTimes(String username) {
        /*获取已登录错误次数*/
        String value = stringRedisTemplate.opsForValue().get("loginFailTime:"+username);
        if(StrUtil.isBlank(value)) value = "0";
        return Integer.parseInt(value);
    }

    @Override
    public void removeLoginFailCache(String username) {
        /*redis删除失败次数缓存*/
        stringRedisTemplate.delete("loginFailTime:"+username);
        /*redis删除失败锁定标志*/
        stringRedisTemplate.delete("loginFailFlag:"+username);
    }


    /*@Override
    public UserVO getUserDetailByUsername(String username) {
        UserVO vo = null;
        try {
            *//*获取用户详情*//*
            Future future = executorService.submit(() -> feignSystemService.getUserDetailByUsername(username) );
            vo = (UserVO) future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return vo;

    }

    @Override
    public UserVO getUserDetailByUserId(String userId) {
        UserVO vo = null;
        try {
            *//*获取用户详情*//*
            Future future = executorService.submit(() -> feignSystemService.getUserDetailByUserId(userId) );
            vo = (UserVO) future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return vo;
    }*/

    @Override
    public void saveLoginLog(UserVO user, AuthLoginCmd cmd) {
        /*组装登录日志参数*/
        LogCreateCmd log = new LogCreateCmd();
        log.setModule("用户认证");
        log.setTitle("登录");
        log.setBusinessType(BusinessType.LOGIN.name());
        log.setMethod("AuthController.login");
        log.setRequestMethod("POST");
        log.setOperName(user.getUsername());
        log.setDepartmentTitle(user.getDepartmentTitle());
        log.setTenantTitle(user.getTenantTitle());
        log.setOperUrl("/login");
        log.setOperIp(cmd.getIp());
        cmd.setPassword(null);//清除密码
        log.setOperParam(JSON.toJSONString(cmd));
        log.setStatus(0);
        log.setErrorMsg("");
        baseFeignLogService.save(log);
    }

    /*@Override
    public void reloadUserDetailCache(String userId) {
        try {
            *//*feign刷新用户详情缓存*//*
            executorService.submit(() ->  feignSystemService.reloadUserDetailCache(userId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public String saLogin(LoginEntity entity) {
        /*清理权限相关信息*/
        SaSessionCustomUtil.deleteSessionById("permission:" + entity.getId());
        /*SaToken登录*/
        StpUtil.login(entity.getId(), entity.getDevice());
        /*拿到登录成功后的token*/
        String token = StpUtil.getTokenValue();
        /*存放一些基础信息到tokenSession*/
        SaSession tokenSession = StpUtil.getTokenSession();
        tokenSession.set("loginTime", DateUtil.dateFormatToStr(DateUtil.DATE_TIME_FORMAT2,new Date()));//登录时间
        tokenSession.set("device",entity.getDevice());//登录设备
        tokenSession.set("ip",entity.getIp());//登录ip
        tokenSession.set("token",token);//登录token
        /*返回token*/
        return token;
    }

    @Override
    public void updateLoginFailTimes(String username, Integer times) {
        /*redis更新错误登录次数*/
        stringRedisTemplate.opsForValue().set("loginFailTime:"+username,
                String.valueOf(times), tokenProperties.getLoginFailCountKeepTime(), TimeUnit.HOURS);
    }

    @Override
    public void lockAccount(String username) {
        /*redis锁定账户 保存锁定标识*/
        stringRedisTemplate.opsForValue().set("loginFailFlag:"+username, "fail", tokenProperties.getLoginAfterTime(), TimeUnit.MINUTES);
    }

    @Override
    public void saveLogoutLog(UserVO user) {
        /*组装登出日志参数*/
        LogCreateCmd log = new LogCreateCmd();
        log.setModule("用户认证");
        log.setTitle("登出");
        log.setBusinessType(BusinessType.LOGOUT.name());
        log.setMethod("AuthController.logout");
        log.setRequestMethod("POST");
        log.setOperName(user.getUsername());
        log.setDepartmentTitle(user.getDepartmentTitle());
        log.setTenantTitle(user.getTenantTitle());
        log.setOperUrl("/logout");
        log.setOperIp(null);
        log.setOperParam("");
        log.setResultStr("");
        log.setStatus(0);
        log.setErrorMsg("");
        baseFeignLogService.save(log);
    }

}
