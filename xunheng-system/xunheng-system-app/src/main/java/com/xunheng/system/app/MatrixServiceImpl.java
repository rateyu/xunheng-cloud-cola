package com.xunheng.system.app;

import com.xunheng.system.client.api.MatrixService;
import com.xunheng.system.client.dto.query.MatrixListQuery;
import com.xunheng.system.client.dto.MatrixSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.app.executor.MatrixRemoveCmdExe;
import com.xunheng.system.app.executor.MatrixSaveCmdExe;
import com.xunheng.system.app.executor.query.MatrixListQueryExe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵信息service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@Transactional
public class MatrixServiceImpl implements MatrixService {

    @Resource
    private MatrixSaveCmdExe matrixSaveCmdExe;

    @Resource
    private MatrixRemoveCmdExe matrixRemoveCmdExe;

    @Resource
    private MatrixListQueryExe matrixListQueryExe;

    @Override
    public List<MatrixVO> getAll(MatrixListQuery query) {
        return matrixListQueryExe.execute(query);
    }

    @Override
    public MatrixVO saveOrUpdate(MatrixSaveCmd cmd) {
        return matrixSaveCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        matrixRemoveCmdExe.execute(id);
    }
}