package com.xunheng.system.app.executor.query;

import com.xunheng.system.app.assembler.MatrixColumnAssembler;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.domain.matrix.gateway.MatrixColumnGateway;
import com.xunheng.system.domain.matrix.model.MatrixColumnEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 根据矩阵的id查询矩阵列处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:42
 */
@Component
public class MatrixColumnListQueryExe {

    @Resource
    MatrixColumnGateway matrixColumnGateway;

    /**
     * @param matrixId 矩阵id
     * @return 矩阵信息
     */
    public MatrixVO execute(String matrixId) {
        List<MatrixColumnEntity> columnList =  matrixColumnGateway.getListByMatrixId(matrixId);
        /*组装矩阵信息vo*/
        MatrixVO matrixVO = new MatrixVO();
        matrixVO.setId(matrixId);
        matrixVO.setColumnList(columnList.stream().map(MatrixColumnAssembler::toVo).collect(Collectors.toList()));
        return matrixVO;
    }
}
