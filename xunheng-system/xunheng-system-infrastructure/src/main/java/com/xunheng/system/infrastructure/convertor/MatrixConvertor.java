package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.Matrix;
import com.xunheng.system.domain.matrix.model.MatrixEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵信息DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class MatrixConvertor {
    public static Matrix toDO(MatrixEntity entity) {
        Matrix db = new Matrix();
        db.setId(entity.getId());
        db.setName(entity.getName());
        db.setDescription(entity.getDescription());
        return db;
    }

    public static MatrixEntity toEntity(Matrix db) {
        if(db == null)return null;
        MatrixEntity entity = new MatrixEntity();
        entity.setId(db.getId());
        entity.setName(db.getName());
        entity.setDescription(db.getDescription());
        return entity;
    }
}
