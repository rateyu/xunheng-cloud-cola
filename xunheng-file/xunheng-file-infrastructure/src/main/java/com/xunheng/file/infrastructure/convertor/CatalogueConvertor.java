package com.xunheng.file.infrastructure.convertor;

import com.xunheng.file.domain.catalogue.model.CatalogueEntity;
import com.xunheng.file.infrastructure.DO.Catalogue;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传目录DO转换
 * @author: hhqkkr
 * @date: 2023/7/10 13:00
 */
public class CatalogueConvertor {

    public static CatalogueEntity toEntity(Catalogue db) {
        if(db == null)return null;
        CatalogueEntity entity = new CatalogueEntity();
        entity.setId(db.getId());
        entity.setTitle(db.getTitle());
        entity.setDir(db.getDir());
        entity.setStatus(db.getStatus());
        entity.setParentId(db.getParentId());
        entity.setSortOrder(db.getSortOrder());
        return entity;
    }

    public static Catalogue toDO(CatalogueEntity entity) {
        if(entity == null)return null;
        Catalogue db = new Catalogue();
        db.setId(entity.getId());
        db.setTitle(entity.getTitle());
        db.setDir(entity.getDir());
        db.setStatus(entity.getStatus());
        db.setParentId(entity.getParentId());
        db.setSortOrder(entity.getSortOrder());
        return db;
    }
}
