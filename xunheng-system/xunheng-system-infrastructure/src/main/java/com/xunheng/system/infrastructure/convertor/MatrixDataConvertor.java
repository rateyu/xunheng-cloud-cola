package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.MatrixData;
import com.xunheng.system.domain.matrix.model.MatrixDataEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵数据DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class MatrixDataConvertor {
    public static MatrixData toDO(MatrixDataEntity entity) {
        MatrixData db = new MatrixData();
        db.setId(entity.getId());
        db.setMatrixId(entity.getMatrixId());
        db.setColumnTag(entity.getColumnTag());
        db.setRowId(entity.getRowId());
        db.setData(entity.getData());
        return db;
    }

    public static MatrixDataEntity toEntity(MatrixData db) {
        if(db == null)return null;
        MatrixDataEntity entity = new MatrixDataEntity();
        entity.setId(db.getId());
        entity.setMatrixId(db.getMatrixId());
        entity.setColumnTag(db.getColumnTag());
        entity.setRowId(db.getRowId());
        entity.setData(db.getData());
        return entity;
    }
}
