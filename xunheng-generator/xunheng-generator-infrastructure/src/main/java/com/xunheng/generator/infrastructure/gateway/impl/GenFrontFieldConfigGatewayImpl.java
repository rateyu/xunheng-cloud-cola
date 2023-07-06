package com.xunheng.generator.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.generator.domain.genConfig.gateway.GenFrontFieldConfigGateway;
import com.xunheng.generator.domain.genConfig.model.GenFrontFieldConfigEntity;
import com.xunheng.generator.infrastructure.DO.GenFrontFieldConfig;
import com.xunheng.generator.infrastructure.convertor.GenFrontFieldConfigConvertor;
import com.xunheng.generator.infrastructure.mapper.GenFrontFieldConfigMapper;
import io.seata.common.util.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器字段配置网关实现类
 * @author: hhqkkr
 * @date: 2023/7/3 18:12
 */
@Component
public class GenFrontFieldConfigGatewayImpl implements GenFrontFieldConfigGateway {

    @Resource
    GenFrontFieldConfigMapper genFrontFieldConfigMapper;


    @Override
    public void removeAllFields() {
        genFrontFieldConfigMapper.delete(new QueryWrapper<>());
    }

    @Override
    public void batchCreate(List<GenFrontFieldConfigEntity> fieldList) {
        if(CollectionUtils.isEmpty(fieldList))return;
        fieldList.forEach(item -> genFrontFieldConfigMapper.insert(GenFrontFieldConfigConvertor.toDO(item)));
    }

    @Override
    public List<GenFrontFieldConfigEntity> listAll() {
        List<GenFrontFieldConfig> list = genFrontFieldConfigMapper.selectList(new QueryWrapper<>());
        return list.stream().map(GenFrontFieldConfigConvertor::toEntity).collect(Collectors.toList());
    }
}
