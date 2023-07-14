package com.xunheng.system.app;

import com.xunheng.system.client.api.MatrixColumnService;
import com.xunheng.system.client.dto.MatrixColumnSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.app.executor.MatrixColumnSaveCmdExe;
import com.xunheng.system.app.executor.query.MatrixColumnListQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵列信息service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class MatrixColumnServiceImpl implements MatrixColumnService {

    @Resource
    private MatrixColumnSaveCmdExe matrixColumnSaveCmdExe;
    @Resource
    MatrixColumnListQueryExe matrixColumnListQueryExe;

    @Override
    public MatrixVO saveMatrixColumn(MatrixColumnSaveCmd cmd) {
        return matrixColumnSaveCmdExe.execute(cmd);
    }

    @Override
    public MatrixVO getColumnByMatrix(String matrixId) {
        return matrixColumnListQueryExe.execute(matrixId);
    }

}