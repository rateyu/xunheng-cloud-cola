package com.xunheng.file.infrastructure.convertor;

import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;
import com.xunheng.file.infrastructure.DO.UploadSetting;

/**
 * @ClassName UploadSettingConvertor
 * @Description
 * @Author hhqkkr
 * @Date 2023/7/10 13:31
 */
public class UploadSettingConvertor {

    public static UploadSettingEntity toEntity(UploadSetting db) {
        if(db == null)return null;
        UploadSettingEntity entity = new UploadSettingEntity();
        entity.setId(db.getId());
        entity.setTitle(db.getTitle());
        entity.setCode(db.getCode());
        entity.setCatalogueId(db.getCatalogueId());
        entity.setMaxSize(db.getMaxSize());
        entity.setLocation(db.getLocation());
        entity.setCatalogueTitle(db.getCatalogueTitle());
        return entity;
    }

    public static UploadSetting toDO(UploadSettingEntity entity) {
        if(entity == null)return null;
        UploadSetting db = new UploadSetting();
        db.setId(entity.getId());
        db.setTitle(entity.getTitle());
        db.setCode(entity.getCode());
        db.setCatalogueId(entity.getCatalogueId());
        db.setMaxSize(entity.getMaxSize());
        db.setLocation(entity.getLocation());
        return db;
    }
}
