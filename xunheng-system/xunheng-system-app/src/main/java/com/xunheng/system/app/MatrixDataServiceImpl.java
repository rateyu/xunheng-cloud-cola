package com.xunheng.system.app;

import com.xunheng.system.app.executor.query.MatrixResultByConditionQueryExe;
import com.xunheng.system.client.api.MatrixDataService;
import com.xunheng.system.client.dto.MatrixDataSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.app.executor.MatrixDataSaveCmdExe;
import com.xunheng.system.app.executor.query.MatrixDataListQueryExe;
import com.xunheng.system.client.dto.query.MatrixResultByConditionQuery;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵数据service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class MatrixDataServiceImpl implements MatrixDataService {

    @Resource
    private MatrixDataSaveCmdExe matrixDataSaveCmdExe;

    @Resource
    MatrixDataListQueryExe matrixDataListQueryExe;

    @Resource
    MatrixResultByConditionQueryExe matrixResultByConditionQueryExe;


    @Override
    public MatrixVO saveMatrixData(MatrixDataSaveCmd cmd) {
        return matrixDataSaveCmdExe.execute(cmd);
    }

    @Override
    public MatrixVO getConfigDataByMatrix(String matrixId) {
        return matrixDataListQueryExe.execute(matrixId);
    }

    @Override
    public List<String> getResultByCondition(MatrixResultByConditionQuery query) {
        return matrixResultByConditionQueryExe.execute(query);
    }

}