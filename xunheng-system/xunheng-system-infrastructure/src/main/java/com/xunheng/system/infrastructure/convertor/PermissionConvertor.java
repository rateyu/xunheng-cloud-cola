package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.Permission;
import com.xunheng.system.domain.permission.model.PermissionEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class PermissionConvertor {
    public static Permission toDO(PermissionEntity entity) {
        Permission db = new Permission();
        db.setId(entity.getId());
        db.setName(entity.getName());
        db.setType(entity.getType());
        db.setTitle(entity.getTitle());
        db.setPath(entity.getPath());
        db.setComponent(entity.getComponent());
        db.setIcon(entity.getIcon());
        db.setFullpage(entity.getFullpage());
        db.setParentId(entity.getParentId());
        db.setSortOrder(entity.getSortOrder());
        db.setStatus(entity.getStatus());
        return db;
    }

    public static PermissionEntity toEntity(Permission db) {
        if(db == null)return null;
        PermissionEntity entity = new PermissionEntity();
        entity.setId(db.getId());
        entity.setName(db.getName());
        entity.setType(db.getType());
        entity.setTitle(db.getTitle());
        entity.setPath(db.getPath());
        entity.setComponent(db.getComponent());
        entity.setIcon(db.getIcon());
        entity.setFullpage(db.getFullpage());
        entity.setParentId(db.getParentId());
        entity.setSortOrder(db.getSortOrder());
        entity.setStatus(db.getStatus());
        return entity;
    }
}
