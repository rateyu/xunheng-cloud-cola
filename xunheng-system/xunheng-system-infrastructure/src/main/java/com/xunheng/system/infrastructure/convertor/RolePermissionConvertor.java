package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.RolePermission;
import com.xunheng.system.domain.role.model.RolePermissionEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色权限DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class RolePermissionConvertor {
    public static RolePermission toDO(RolePermissionEntity entity) {
        RolePermission db = new RolePermission();
        db.setId(entity.getId());
        db.setRoleId(entity.getRoleId());
        db.setPermissionId(entity.getPermissionId());
        db.setIsAllCheck(entity.getIsAllCheck());
        return db;
    }

    public static RolePermissionEntity toEntity(RolePermission db) {
        if(db == null)return null;
        RolePermissionEntity entity = new RolePermissionEntity();
        entity.setId(db.getId());
        entity.setRoleId(db.getRoleId());
        entity.setPermissionId(db.getPermissionId());
        entity.setIsAllCheck(db.getIsAllCheck());
        return entity;
    }
}
