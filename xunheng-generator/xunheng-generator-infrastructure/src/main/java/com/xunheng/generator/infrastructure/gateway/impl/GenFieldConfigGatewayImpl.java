package com.xunheng.generator.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.generator.domain.genConfig.gateway.GenFieldConfigGateway;
import com.xunheng.generator.domain.genConfig.model.GenFieldConfigEntity;
import com.xunheng.generator.infrastructure.DO.GenFieldConfig;
import com.xunheng.generator.infrastructure.convertor.GenFieldConfigConvertor;
import com.xunheng.generator.infrastructure.mapper.GenFieldConfigMapper;
import io.seata.common.util.CollectionUtils;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器字段配置网关实现类
 * @author: hhqkkr
 * @date: 2023/7/3 18:12
 */
@Component
public class GenFieldConfigGatewayImpl implements GenFieldConfigGateway {

    @Resource
    GenFieldConfigMapper genFieldConfigMapper;


    @Override
    public void removeAllFields() {
        genFieldConfigMapper.delete(new QueryWrapper<>());
    }

    @Override
    public void batchCreate(List<GenFieldConfigEntity> fieldList) {
        if(CollectionUtils.isEmpty(fieldList))return;
        fieldList.forEach(item -> genFieldConfigMapper.insert(GenFieldConfigConvertor.toDO(item)));
    }

    @Override
    public List<GenFieldConfigEntity> listAll() {
        List<GenFieldConfig> list = genFieldConfigMapper.selectList(new QueryWrapper<>());
        return list.stream().map(GenFieldConfigConvertor::toEntity).collect(Collectors.toList());
    }
}
