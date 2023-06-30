package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.MatrixColumnSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵列信息service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:07
 */
public interface MatrixColumnService {

    /**
     * 保存矩阵列信息
     * @param cmd 保存操作dto
     * @return 矩阵信息
     */
    MatrixVO saveMatrixColumn(MatrixColumnSaveCmd cmd);

    /**
     * 根据矩阵获取列信息
     * @param matrixId 矩阵id
     * @return 矩阵信息
     */
    MatrixVO getColumnByMatrix(String matrixId);

}
