package com.xunheng.system.domain.role.gateway;

import com.xunheng.system.domain.role.model.RolePermissionEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色权限网关
 * @author: hhqkkr
 * @date: 2023/6/30 00:06
 */
public interface RolePermissionGateway {

    /**
     * 根据角色id获取角色权限集合
     * @param id 角色id
     * @return 角色权限集合
     */
    List<RolePermissionEntity> getByRoleId(String id);

    /**
     * 根据角色id删除角色权限
     * @param id 角色id
     */
    void deleteByRoleId(String id);

    /**
     * 创建角色权限
     * @param rolePermission 角色权限实体
     */
    void create(RolePermissionEntity rolePermission);

    /**
     * 根据权限id获取角色权限集合
     * @param id 权限id
     * @return 角色权限集合
     */
    List<RolePermissionEntity> getByPermissionId(String id);
}
