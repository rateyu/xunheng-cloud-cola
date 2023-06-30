package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.MatrixColumn;
import com.xunheng.system.domain.matrix.model.MatrixColumnEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵列DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class MatrixColumnConvertor {
    public static MatrixColumn toDO(MatrixColumnEntity entity) {
        MatrixColumn db = new MatrixColumn();
        db.setId(entity.getId());
        db.setMatrixId(entity.getMatrixId());
        db.setTitle(entity.getTitle());
        db.setTag(entity.getTag());
        db.setType(entity.getType());
        db.setSortOrder(entity.getSortOrder());
        return db;
    }

    public static MatrixColumnEntity toEntity(MatrixColumn db) {
        if(db == null)return null;
        MatrixColumnEntity entity = new MatrixColumnEntity();
        entity.setId(db.getId());
        entity.setMatrixId(db.getMatrixId());
        entity.setTitle(db.getTitle());
        entity.setTag(db.getTag());
        entity.setType(db.getType());
        entity.setSortOrder(db.getSortOrder());
        return entity;
    }
}
