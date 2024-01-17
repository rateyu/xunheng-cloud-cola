package com.xunheng.system.domain.login.gateway;

import com.xunheng.system.client.dto.AuthLoginCmd;
import com.xunheng.system.domain.login.model.CaptchaEntity;
import com.xunheng.system.domain.login.model.LoginEntity;
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
     * 保存登录日志
     * @param userVO 用户详情
     * @param cmd 登录操作DTO
     */
    void saveLoginLog(UserVO userVO, AuthLoginCmd cmd);


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
