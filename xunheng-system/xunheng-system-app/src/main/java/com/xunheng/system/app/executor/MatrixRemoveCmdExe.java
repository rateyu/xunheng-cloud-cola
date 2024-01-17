package com.xunheng.system.app.executor;


import com.xunheng.system.domain.matrix.gateway.MatrixColumnGateway;
import com.xunheng.system.domain.matrix.gateway.MatrixDataGateway;
import com.xunheng.system.domain.matrix.gateway.MatrixGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵信息删除处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:13
 */
@Component
public class MatrixRemoveCmdExe {

    @Resource
    private MatrixGateway matrixGateway;

    @Resource
    private MatrixDataGateway matrixDataGateway;

    @Resource
    private MatrixColumnGateway matrixColumnGateway;

    public void execute(String id) {
        /*删除数据*/
        matrixDataGateway.removeByMatrixId(id);
        /*删除列信息*/
        matrixColumnGateway.removeByMatrixId(id);
        /*删除矩阵信息*/
        matrixGateway.remove(id);
    }
}
