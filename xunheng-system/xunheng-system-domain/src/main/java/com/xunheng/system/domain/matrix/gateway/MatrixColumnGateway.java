package com.xunheng.system.domain.matrix.gateway;

import com.xunheng.system.domain.matrix.model.MatrixColumnEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵列网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:49
 */
public interface MatrixColumnGateway {

    /**
     * 删除矩阵列
     * @param id 矩阵列id
     */
    void remove(String id);

    /**
     * 矩阵列新增
     * @param entity 矩阵列实体
     * @return 矩阵列实体
     */
    MatrixColumnEntity create(MatrixColumnEntity entity);

    /**
     * 根据矩阵id删除矩阵列
     * @param matrixId 矩阵id
     */
    void removeByMatrixId(String matrixId);

    /**
     * 根据矩阵id获取矩阵列集合
     * @param matrixId 矩阵id
     * @return 矩阵列集合
     */
    List<MatrixColumnEntity> getListByMatrixId(String matrixId);
}
