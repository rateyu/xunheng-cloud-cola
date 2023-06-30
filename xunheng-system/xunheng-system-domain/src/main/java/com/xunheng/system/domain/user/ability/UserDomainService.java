package com.xunheng.system.domain.user.ability;

import com.xunheng.system.domain.user.model.UserEntity;
import org.apache.kafka.common.protocol.types.Field;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户领域服务
 * @author: hhqkkr
 * @date: 2023/6/30 00:21
 */
public interface UserDomainService {

    /**
     * 根据用户名获取用户详情
     * @param username 用户名
     * @return 用户实体
     */
    UserEntity getUserDetailByUsername(String username);

    /**
     * 根据id获取用户详情
     * @param userId 用户id
     * @return 用户实体
     */
    UserEntity getUserDetailById(String userId);

    /**
     * 是否是超级管理员
     * @param userId 用户id
     * @return 是否
     */
    Boolean isSuperAdmin(String userId);

    /**
     * 刷新用户详情缓存
     * @param userId 用户id
     */
    void reloadUserDetailCache(String userId);
}
