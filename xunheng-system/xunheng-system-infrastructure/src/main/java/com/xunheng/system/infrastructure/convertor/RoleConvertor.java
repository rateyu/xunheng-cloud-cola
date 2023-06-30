package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.Role;
import com.xunheng.system.domain.role.model.RoleEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class RoleConvertor {
    public static Role toDO(RoleEntity entity) {
        Role db = new Role();
        db.setId(entity.getId());
        db.setName(entity.getName());
        db.setDataType(entity.getDataType());
        db.setDataLevel(entity.getDataLevel());
        db.setCustomExpression(entity.getCustomExpression());
        db.setIncludeLow(entity.getIncludeLow());
        db.setDescription(entity.getDescription());
        return db;
    }

    public static RoleEntity toEntity(Role db) {
        if(db == null)return null;
        RoleEntity entity = new RoleEntity();
        entity.setId(db.getId());
        entity.setName(db.getName());
        entity.setDataType(db.getDataType());
        entity.setDataLevel(db.getDataLevel());
        entity.setCustomExpression(db.getCustomExpression());
        entity.setIncludeLow(db.getIncludeLow());
        entity.setDescription(db.getDescription());
        return entity;
    }
}
