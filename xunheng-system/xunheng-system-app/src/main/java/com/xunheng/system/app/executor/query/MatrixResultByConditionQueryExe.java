package com.xunheng.system.app.executor.query;

import com.xunheng.system.client.dto.query.MatrixResultByConditionQuery;
import com.xunheng.system.domain.matrix.gateway.MatrixDataGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵匹配结果查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:49
 */
@Component
public class MatrixResultByConditionQueryExe {

    @Resource
    private MatrixDataGateway matrixDataGateway;

    public List<String> execute(MatrixResultByConditionQuery query) {
        return matrixDataGateway.searchByCondition(query);
    }
}
