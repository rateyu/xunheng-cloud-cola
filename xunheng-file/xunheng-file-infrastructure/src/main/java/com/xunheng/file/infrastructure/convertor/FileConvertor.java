package com.xunheng.file.infrastructure.convertor;

import com.xunheng.file.domain.file.model.FileEntity;
import com.xunheng.file.infrastructure.DO.File;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件DO转换
 * @author: hhqkkr
 * @date: 2023/7/10 17:11
 */
public class FileConvertor {

    public static File toDO(FileEntity entity){
        if(entity == null)return null;
        File db = new File();
        db.setName(entity.getName());
        db.setFKey(entity.getFKey());
        db.setSize(entity.getSize());
        db.setType(entity.getType());
        db.setUrl(entity.getUrl());
        db.setCatalogueId(entity.getCatalogueId());
        db.setSettingId(entity.getSettingId());
        db.setMainId(entity.getMainId());
        db.setLocation(entity.getLocation());
        return db;
    }


    public static FileEntity toEntity(File db){
        if(db == null)return null;
        FileEntity entity = new FileEntity();
        entity.setId(db.getId());
        entity.setName(db.getName());
        entity.setFKey(db.getFKey());
        entity.setSize(db.getSize());
        entity.setType(db.getType());
        entity.setUrl(db.getLocation());
        entity.setCatalogueId(db.getCatalogueId());
        entity.setSettingId(db.getSettingId());
        entity.setMainId(db.getMainId());
        entity.setNickname(db.getName());
        entity.setLocation(db.getLocation());
        return entity;
    }
}
