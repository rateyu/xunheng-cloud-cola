package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.UserRole;
import com.xunheng.system.domain.user.model.UserRoleEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户角色DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class UserRoleConvertor {
    public static UserRole toDO(UserRoleEntity entity) {
        UserRole db = new UserRole();
        db.setId(entity.getId());
        db.setUserId(entity.getUserId());
        db.setRoleId(entity.getRoleId());
        return db;
    }

    public static UserRoleEntity toEntity(UserRole db) {
        if(db == null)return null;
        UserRoleEntity entity = new UserRoleEntity();
        entity.setId(db.getId());
        entity.setUserId(db.getUserId());
        entity.setRoleId(db.getRoleId());
        entity.setRoleName(db.getRoleName());
        entity.setRoleDescription(db.getRoleDescription());
        entity.setDataType(db.getDataType());;
        return entity;
    }
}
