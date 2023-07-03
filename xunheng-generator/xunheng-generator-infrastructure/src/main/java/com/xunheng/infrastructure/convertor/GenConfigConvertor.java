package com.xunheng.infrastructure.convertor;

import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;
import com.xunheng.infrastructure.DO.GenConfig;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成DO转换
 * @author: hhqkkr
 * @date: 2023/7/3 18:14
 */
public class GenConfigConvertor {

    public static GenConfig toDO(GenConfigEntity entity){
        if(entity == null)return null;
        GenConfig db = new GenConfig();
        db.setId(entity.getId());
        db.setName(entity.getName());
        db.setDescription(entity.getDescription());
        db.setAuthor(entity.getAuthor());
        db.setTablePrefix(entity.getTablePrefix());
        db.setTableAlias(entity.getTableAlias());
        db.setServiceName(entity.getServiceName());
        return db;
    }

    public static GenConfigEntity toEntity(GenConfig db){
        if(db == null)return null;
        GenConfigEntity entity = new GenConfigEntity();
        entity.setId(db.getId());
        entity.setName(db.getName());
        entity.setDescription(db.getDescription());
        entity.setAuthor(db.getAuthor());
        entity.setTablePrefix(db.getTablePrefix());
        entity.setTableAlias(db.getTableAlias());
        entity.setServiceName(db.getServiceName());
        return entity;
    }
}
