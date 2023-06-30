package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.MatrixDataSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.client.dto.query.MatrixResultByConditionQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵数据service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:07
 */
public interface MatrixDataService {

    /**
     * 保存矩阵数据
     * @param cmd 保存操作dto
     * @return 矩阵信息
     */
    MatrixVO saveMatrixData(MatrixDataSaveCmd cmd);

    /**
     * 根据矩阵id获取数据
     * @param matrixId 矩阵id
     * @return 矩阵信息
     */
    MatrixVO getConfigDataByMatrix(String matrixId);

    /**
     * 根据条件获取对应数据
     * @param query 查询条件
     * @return 符合条件的结果集
     */
    List<String> getResultByCondition(MatrixResultByConditionQuery query);
}
