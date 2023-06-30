package com.xunheng.auth.domain.login.gateway;

import com.xunheng.auth.client.dto.AuthLoginCmd;
import com.xunheng.auth.domain.login.model.CaptchaEntity;
import com.xunheng.auth.domain.login.model.LoginEntity;
import com.xunheng.base.vo.system.UserLoginVO;
import com.xunheng.base.vo.system.UserVO;

/**
 * @program: xunheng-cloud-cola
 * @description: 登录网关
 * @author: hhqkkr
 * @date: 2023/6/29 13:53
 */
public interface LoginGateway {

    /**
     * 缓存验证码
     * @param entity 验证码实体
     */
    void cacheCaptcha(CaptchaEntity entity);

    /**
     * 清除验证码
     * @param captchaId 验证码id
     */
    void removeCaptcha(String captchaId);

    /**
     * 通过id获取验证码
     * @param captchaId
     * @return 验证码
     */
    String getCaptchaCodeById(String captchaId);

    /**
     * 获取登录锁定剩余时间
     * @param username 用户名
     * @return 剩余时间
     */
    Long getLockTimeRest(String username);

    /**
     * 获取登录失败次数
     * @param username 用户名
     * @return 失败次数
     */
    Integer getLoginFailTimes(String username);

    /**
     * 清除错误登录信息缓存
     * @param username 用户名
     */
    void removeLoginFailCache(String username);

    /**
     * 校验租户是否过期
     * @param tenantId 租户id
     */
    void checkTenantExpire(String tenantId);

    /**
     * 登录时获取用户信息
     * @param login 登录实体
     * @return 用户信息
     */
    UserLoginVO getUserLoginInfo(LoginEntity login);

    /**
     * 通过用户名获取用户详情
     * @param username 用户名
     * @return 用户详情
     */
    UserVO getUserDetailByUsername(String username);

    /**
     * 通过用户id获取用户详情
     * @param userId 用户id
     * @return 用户详情
     */
    UserVO getUserDetailByUserId(String userId);

    /**
     * 保存登录日志
     * @param userVO 用户详情
     * @param cmd 登录操作DTO
     */
    void saveLoginLog(UserVO userVO, AuthLoginCmd cmd);

    /**
     * 刷新用户详情缓存
     * @param userId 用户id
     */
    void reloadUserDetailCache(String userId);

    /**
     * sa登录
     * @param entity 登录实体
     * @return token
     */
    String saLogin(LoginEntity entity);

    /**
     * 更新登录失败次数
     * @param username 用户名
     * @param times 次数
     */
    void updateLoginFailTimes(String username, Integer times);

    /**
     * 锁定账户
     * @param username 用户名
     */
    void lockAccount(String username);

    /**
     * 保存登出日志
     * @param userVO 用户详情
     */
    void saveLogoutLog(UserVO userVO);

}
