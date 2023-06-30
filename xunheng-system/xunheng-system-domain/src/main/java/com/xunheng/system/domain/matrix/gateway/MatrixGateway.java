package com.xunheng.system.domain.matrix.gateway;

import com.xunheng.system.domain.matrix.model.MatrixEntity;
import com.xunheng.system.client.dto.query.MatrixListQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵信息网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:53
 */
public interface MatrixGateway {

    /**
     * 获取所有矩阵信息
     * @param query 查询条件dto
     * @return 矩阵信息集合
     */
    List<MatrixEntity> getAll(MatrixListQuery query);

    /**
     * 保存或更新矩阵信息
     * @param entity 矩阵实体
     * @return 矩阵实体
     */
    MatrixEntity saveOrUpdate(MatrixEntity entity);

    /**
     * 删除矩阵信息
     * @param id 矩阵id
     */
    void remove(String id);

}
