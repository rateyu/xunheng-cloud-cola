package com.xunheng.generator.infrastructure.convertor;

import com.xunheng.generator.domain.genConfig.model.GenFrontFieldConfigEntity;
import com.xunheng.generator.infrastructure.DO.GenFrontFieldConfig;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成前端字段配置DO转换
 * @author: hhqkkr
 * @date: 2023/7/3 18:14
 */
public class GenFrontFieldConfigConvertor {

    public static GenFrontFieldConfig toDO(GenFrontFieldConfigEntity entity){
        if(entity == null)return null;
        GenFrontFieldConfig db = new GenFrontFieldConfig();
        db.setFieldName(entity.getFieldName());
        db.setDescription(entity.getDescription());
        db.setType(entity.getType());
        db.setColWidth(entity.getColWidth());
        db.setDictType(entity.getDictType());
        db.setApi(entity.getApi());
        db.setSearchable(entity.getSearchable());
        db.setSearchType(entity.getSearchType());
        return db;
    }

    public static GenFrontFieldConfigEntity toEntity(GenFrontFieldConfig db){
        if(db == null)return null;
        GenFrontFieldConfigEntity entity = new GenFrontFieldConfigEntity();
        entity.setId(db.getId());
        entity.setFieldName(db.getFieldName());
        entity.setDescription(db.getDescription());
        entity.setType(db.getType());
        entity.setColWidth(db.getColWidth());
        entity.setDictType(db.getDictType());
        entity.setApi(db.getApi());
        entity.setSearchable(db.getSearchable());
        entity.setSearchType(db.getSearchType());
        return entity;
    }
}
