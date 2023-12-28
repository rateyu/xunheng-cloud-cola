package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.infrastructure.DO.MatrixColumn;
import com.xunheng.system.infrastructure.convertor.MatrixColumnConvertor;
import com.xunheng.system.domain.matrix.gateway.MatrixColumnGateway;
import com.xunheng.system.infrastructure.mapper.MatrixColumnMapper;
import com.xunheng.system.domain.matrix.model.MatrixColumnEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵列网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:35
 */
@Slf4j
@Component
public class MatrixColumnGatewayImpl implements MatrixColumnGateway {

    @Resource
    MatrixColumnMapper matrixColumnMapper;

    @Override
    public MatrixColumnEntity create(MatrixColumnEntity entity) {
        MatrixColumn matrixColumn = MatrixColumnConvertor.toDO(entity);
        matrixColumnMapper.insert(matrixColumn);
        return MatrixColumnConvertor.toEntity(matrixColumn);
    }

    @Override
    public List<MatrixColumnEntity> getListByMatrixId(String matrixId) {
        QueryWrapper<MatrixColumn> wrapper = new QueryWrapper<>();
        wrapper.eq("matrix_id",matrixId);
        wrapper.orderByAsc("sort_order");
        List<MatrixColumn> columnList = matrixColumnMapper.selectList(wrapper);
        return columnList.stream().map(MatrixColumnConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public void removeByMatrixId(String matrixId) {
        QueryWrapper<MatrixColumn> wrapper = new QueryWrapper<>();
        wrapper.eq("matrix_id",matrixId);
        matrixColumnMapper.delete(wrapper);
    }

    @Override
    public void remove(String id) {
        matrixColumnMapper.deleteById(id);
    }

}
