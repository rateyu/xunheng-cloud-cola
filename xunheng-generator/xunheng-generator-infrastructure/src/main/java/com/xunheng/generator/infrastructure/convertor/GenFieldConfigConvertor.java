package com.xunheng.generator.infrastructure.convertor;

import com.xunheng.generator.domain.genConfig.model.GenFieldConfigEntity;
import com.xunheng.generator.infrastructure.DO.GenFieldConfig;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成字段配置DO转换
 * @author: hhqkkr
 * @date: 2023/7/3 18:14
 */
public class GenFieldConfigConvertor {

    public static GenFieldConfig toDO(GenFieldConfigEntity entity){
        if(entity == null)return null;
        GenFieldConfig db = new GenFieldConfig();
        db.setFieldName(entity.getFieldName());
        db.setDescription(entity.getDescription());
        db.setType(entity.getType());
        db.setDefaultVal(entity.getDefaultVal());
        db.setCindex(entity.getCindex());
        db.setNotNull(entity.getNotNull());
        return db;
    }

    public static GenFieldConfigEntity toEntity(GenFieldConfig db){
        if(db == null)return null;
        GenFieldConfigEntity entity = new GenFieldConfigEntity();
        entity.setId(db.getId());
        entity.setFieldName(db.getFieldName());
        entity.setDescription(db.getDescription());
        entity.setType(db.getType());
        entity.setDefaultVal(db.getDefaultVal());
        entity.setCindex(db.getCindex());
        entity.setNotNull(db.getNotNull());
        entity.setFieldUpperCaseName(entity.name(entity.getFieldName(),true));
        return entity;

    }
}
