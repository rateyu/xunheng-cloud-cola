package com.xunheng.system.app.executor.query;

import com.xunheng.system.app.assembler.MatrixAssembler;
import com.xunheng.system.client.dto.query.MatrixListQuery;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.domain.matrix.gateway.MatrixGateway;
import com.xunheng.system.domain.matrix.model.MatrixEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵信息查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:48
 */
@Component
public class MatrixListQueryExe {
    @Resource
    MatrixGateway matrixGateway;

    public List<MatrixVO> execute(MatrixListQuery query) {
        List<MatrixEntity> list = matrixGateway.getAll(query);
        return list.stream().map(MatrixAssembler::toVo).collect(Collectors.toList());
    }
}
