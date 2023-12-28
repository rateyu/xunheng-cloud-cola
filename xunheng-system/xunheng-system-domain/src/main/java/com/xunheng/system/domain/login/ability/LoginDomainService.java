package com.xunheng.system.domain.login.ability;

import com.xunheng.system.domain.login.model.LoginEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 登陆领域服务
 * @author: hhqkkr
 * @date: 2023/6/29 13:11
 */
public interface LoginDomainService {

    /**
     * 校验登陆信息有效性 错误则抛出异常
     * @param login 登陆实体
     */
    void checkValidation(LoginEntity login);

    /**
     * sa登陆
     * @param entity 登里实体
     * @return token
     */
    String saLogin(LoginEntity entity);

    /**
     * sa登出
     * @param userId 用户id
     */
    void saLogout(String userId);
}
