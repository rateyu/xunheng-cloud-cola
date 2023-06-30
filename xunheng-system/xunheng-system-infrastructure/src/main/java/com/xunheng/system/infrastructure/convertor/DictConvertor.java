package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.Dict;
import com.xunheng.system.domain.dict.model.DictEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典信息DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class DictConvertor {
    public static Dict toDO(DictEntity entity) {
        Dict db = new Dict();
        db.setId(entity.getId());
        db.setTitle(entity.getTitle());
        db.setType(entity.getDictType());
        db.setDescription(entity.getDescription());
        db.setSortOrder(entity.getSortOrder());
        return db;
    }

    public static DictEntity toEntity(Dict db) {
        if(db == null)return null;
        DictEntity entity = new DictEntity();
        entity.setId(db.getId());
        entity.setTitle(db.getTitle());
        entity.setDictType(db.getType());
        entity.setDescription(db.getDescription());
        entity.setSortOrder(db.getSortOrder());
        return entity;
    }
}
