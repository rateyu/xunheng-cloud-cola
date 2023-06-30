package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.PermissionAction;
import com.xunheng.system.domain.permission.model.PermissionActionEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限功能DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class PermissionActionConvertor {
    public static PermissionAction toDO(PermissionActionEntity entity) {
        PermissionAction db = new PermissionAction();
        db.setId(entity.getId());
        db.setPermissionId(entity.getPermissionId());
        db.setName(entity.getName());
        db.setCode(entity.getCode());
        db.setStatus(entity.getStatus());
        return db;
    }

    public static PermissionActionEntity toEntity(PermissionAction db) {
        if(db == null)return null;
        PermissionActionEntity entity = new PermissionActionEntity();
        entity.setId(db.getId());
        entity.setPermissionId(db.getPermissionId());
        entity.setCode(db.getCode());
        entity.setName(db.getName());
        entity.setStatus(db.getStatus());
        return entity;
    }
}
