package com.xunheng.system.app.executor;


import com.xunheng.system.app.assembler.MatrixAssembler;
import com.xunheng.system.client.dto.MatrixSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.domain.matrix.gateway.MatrixGateway;
import com.xunheng.system.domain.matrix.model.MatrixEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵信息保存操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:13
 */
@Component
public class MatrixSaveCmdExe {

    @Resource
    private MatrixGateway matrixGateway;

    public MatrixVO execute(MatrixSaveCmd cmd) {
        MatrixEntity saveEntity = MatrixAssembler.toSaveEntity(cmd);
        return MatrixAssembler.toVo( matrixGateway.saveOrUpdate(saveEntity));
    }
}
