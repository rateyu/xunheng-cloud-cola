package com.xunheng.system.domain.matrix.gateway;

import com.xunheng.system.client.dto.query.MatrixResultByConditionQuery;
import com.xunheng.system.domain.matrix.model.MatrixDataEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵数据网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:50
 */
public interface MatrixDataGateway {

    /**
     * 保存或更新矩阵数据
     * @param entity 矩阵数据实体
     * @return 矩阵数据实体
     */
    MatrixDataEntity saveOrUpdate(MatrixDataEntity entity);

    /**
     * 根据矩阵id，行id，列标识获取矩阵数据
     * @param matrixId 矩阵id
     * @param rowId 行id
     * @param columnTag 列标识
     * @return 矩阵数据
     */
    MatrixDataEntity getMatrixData(String matrixId,String rowId,String columnTag);

    /**
     * 根据矩阵id获取矩阵数据集合
     * @param matrixId 矩阵id
     * @return 矩阵数据集合
     */
    List<MatrixDataEntity> getListByMatrixId(String matrixId);

    /**
     * 删除矩阵数据
     * @param id 矩阵数据id
     */
    void remove(String id);

    /**
     * 根据行id删除矩阵数据
     * @param rowId 行id
     */
    void removeByRowId(String rowId);

    /**
     * 根据矩阵id删除矩阵数据
     * @param matrixId 矩阵id
     */
    void removeByMatrixId(String matrixId);

    /**
     * 根据条件找到匹配矩阵数据
     * @param query 查询条件
     * @return 矩阵数据集合
     */
    List<String> searchByCondition(MatrixResultByConditionQuery query);
}
