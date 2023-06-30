package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.DictData;
import com.xunheng.system.domain.dict.model.DictDataEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典信息DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class DictDataConvertor {
    public static DictData toDO(DictDataEntity entity) {
        DictData db = new DictData();
        db.setId(entity.getId());
        db.setTitle(entity.getTitle());
        db.setValue(entity.getValue());
        db.setSortOrder(entity.getSortOrder());
        db.setStatus(entity.getStatus());
        db.setDescription(entity.getDescription());
        if(entity.getDictEntity() != null)db.setDictId(entity.getDictEntity().getId());
        return db;
    }

    public static DictDataEntity toEntity(DictData db) {
        if(db == null)return null;
        DictDataEntity entity = new DictDataEntity();
        entity.setId(db.getId());
        entity.setTitle(db.getTitle());
        entity.setValue(db.getValue());
        entity.setSortOrder(db.getSortOrder());
        entity.setStatus(db.getStatus());
        entity.setDescription(db.getDescription());
        entity.setDictEntity(DictConvertor.toEntity(db.getDictInfo()));
        return entity;
    }
}
