package com.xunheng.system.domain.user.gateway;

import com.xunheng.system.domain.user.model.UserRoleEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户角色网关
 * @author: hhqkkr
 * @date: 2023/6/30 00:17
 */
public interface UserRoleGateway {

    /**
     * 根据角色id获取用户角色集合
     * @param roleId 角色id
     * @return 用户角色集合
     */
    List<UserRoleEntity> getByRoleId(String roleId);

    /**
     * 根据用户id删除用户角色信息
     * @param userId 用户id
     */
    void removeByUserId(String userId);

    /**
     * 根据用户id获取用户角色集合
     * @param userId 用户id
     * @return 用户角色集合
     */
    List<UserRoleEntity> getByUserId(String userId);

    /**
     * 创建用户角色信息
     * @param userId 用户id
     * @param roleId 角色id
     */
    void create(String userId, String roleId);

}
