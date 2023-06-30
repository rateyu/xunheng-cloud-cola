package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.CustomConfig;
import com.xunheng.system.domain.customConfig.model.CustomConfigEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 个性化设置DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class CustomConfigConvertor {
    public static CustomConfig toDO(CustomConfigEntity entity) {
        CustomConfig db = new CustomConfig();
        db.setId(entity.getId());
        db.setPersonal(entity.getPersonal());
        db.setUserId(entity.getUserId());
        db.setConfigType(entity.getConfigType());
        db.setConfigKey(entity.getConfigKey());
        db.setConfigValue(entity.getConfigValue());
        db.setConfigTitle(entity.getConfigTitle());
        return db;
    }

    public static CustomConfigEntity toEntity(CustomConfig db) {
        if(db == null)return null;
        CustomConfigEntity entity = new CustomConfigEntity();
        entity.setId(db.getId());
        entity.setPersonal(db.getPersonal());
        entity.setUserId(db.getUserId());
        entity.setConfigType(db.getConfigType());
        entity.setConfigKey(db.getConfigKey());
        entity.setConfigValue(db.getConfigValue());
        entity.setConfigTitle(db.getConfigTitle());
        return entity;
    }
}
