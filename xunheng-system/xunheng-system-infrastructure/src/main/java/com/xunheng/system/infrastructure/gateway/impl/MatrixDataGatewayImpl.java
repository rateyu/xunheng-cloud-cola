package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.client.dto.query.MatrixResultByConditionQuery;
import com.xunheng.system.infrastructure.DO.MatrixData;
import com.xunheng.system.infrastructure.convertor.MatrixDataConvertor;
import com.xunheng.system.domain.matrix.gateway.MatrixDataGateway;
import com.xunheng.system.infrastructure.mapper.MatrixDataMapper;
import com.xunheng.system.domain.matrix.model.MatrixDataEntity;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵数据网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:34
 */
@Slf4j
@Component
public class MatrixDataGatewayImpl implements MatrixDataGateway {

    @Resource
    MatrixDataMapper matrixDataMapper;

    @Override
    public MatrixDataEntity saveOrUpdate(MatrixDataEntity entity) {
        MatrixData matrixData = MatrixDataConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(matrixData.getId()) ? matrixDataMapper.insert(matrixData) : matrixDataMapper.updateById(matrixData);
        return MatrixDataConvertor.toEntity(matrixData);
    }

    @Override
    public MatrixDataEntity getMatrixData(String matrixId, String rowId, String columnTag) {
        QueryWrapper<MatrixData> wrapper = new QueryWrapper<>();
        wrapper.eq("matrix_id",matrixId);
        wrapper.eq("column_tag",columnTag);
        wrapper.eq("row_id",rowId);
        MatrixData matrixData = matrixDataMapper.selectOne(wrapper);
        return MatrixDataConvertor.toEntity(matrixData);
    }

    @Override
    public List<MatrixDataEntity> getListByMatrixId(String matrixId) {
        QueryWrapper<MatrixData> wrapper = new QueryWrapper<>();
        wrapper.eq("matrix_id",matrixId);
        wrapper.orderByAsc("create_time");
        List<MatrixData> matrixDataList = matrixDataMapper.selectList(wrapper);
        return matrixDataList.stream().map(MatrixDataConvertor::toEntity).collect(Collectors.toList());

    }

    @Override
    public void remove(String id) {
        matrixDataMapper.deleteById(id);
    }

    @Override
    public void removeByRowId(String rowId) {
        QueryWrapper<MatrixData> wrapper = new QueryWrapper<>();
        wrapper.eq("row_id",rowId);
        matrixDataMapper.delete(wrapper);
    }

    @Override
    public void removeByMatrixId(String matrixId) {
        QueryWrapper<MatrixData> wrapper = new QueryWrapper<>();
        wrapper.eq("matrix_id",matrixId);
        matrixDataMapper.delete(wrapper);
    }

    @Override
    public List<String> searchByCondition(MatrixResultByConditionQuery query) {
        //根据条件 找到对应的矩阵内 符合查询条件的对应行号
        QueryWrapper<MatrixData> wrapper = new QueryWrapper<>();
        wrapper.eq("matrix_id",query.getMatrixId());
        wrapper.eq("column_tag",query.getConditionColumnTag());
        wrapper.eq("data",query.getConditionColumnData());
        List<MatrixData> conditionDataList = matrixDataMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(conditionDataList))return new ArrayList<>();
        //根据行号与要求的列标识 拿到结果集
        List<String> rowIds = conditionDataList.stream().map(MatrixData :: getRowId).collect(Collectors.toList());
        wrapper = new QueryWrapper<>();
        wrapper.in("row_id",rowIds);
        wrapper.eq("column_tag",query.getResultColumnTag());
        List<MatrixData> resultDataList = matrixDataMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(resultDataList))return new ArrayList<>();
        return resultDataList.stream().map(MatrixData :: getData).collect(Collectors.toList());
    }
}
