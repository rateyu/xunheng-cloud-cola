package com.xunheng.system.infrastructure.gateway.impl;

import com.xunheng.system.infrastructure.DO.Matrix;
import com.xunheng.system.infrastructure.convertor.MatrixConvertor;
import com.xunheng.system.client.dto.query.MatrixListQuery;
import com.xunheng.system.domain.matrix.gateway.MatrixGateway;
import com.xunheng.system.infrastructure.mapper.MatrixMapper;
import com.xunheng.system.domain.matrix.model.MatrixEntity;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:34
 */
@Slf4j
@Component
public class MatrixGatewayImpl implements MatrixGateway {

    @Resource
    MatrixMapper matrixMapper;

    @Override
    public List<MatrixEntity> getAll(MatrixListQuery query) {
        List<Matrix> list = matrixMapper.allList(query);
        return list.stream().map(MatrixConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public MatrixEntity saveOrUpdate(MatrixEntity entity) {
        Matrix matrix = MatrixConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(matrix.getId()) ? matrixMapper.insert(matrix) : matrixMapper.updateById(matrix);
        return MatrixConvertor.toEntity(matrix);
    }

    @Override
    public void remove(String id) {
        matrixMapper.deleteById(id);
    }
}
