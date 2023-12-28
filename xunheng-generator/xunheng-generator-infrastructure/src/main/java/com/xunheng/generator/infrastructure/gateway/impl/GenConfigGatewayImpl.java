package com.xunheng.generator.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.generator.domain.genConfig.gateway.GenConfigGateway;
import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;
import com.xunheng.generator.infrastructure.DO.GenConfig;
import com.xunheng.generator.infrastructure.convertor.GenConfigConvertor;
import com.xunheng.generator.infrastructure.mapper.GenConfigMapper;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器网关实现类
 * @author: hhqkkr
 * @date: 2023/7/3 18:12
 */
@Component
public class GenConfigGatewayImpl implements GenConfigGateway {

    @Resource
    GenConfigMapper genConfigMapper;

    @Override
    public GenConfigEntity getConfig() {
        GenConfig one = genConfigMapper.selectOne(new QueryWrapper<>());
        return GenConfigConvertor.toEntity(one);
    }

    @Override
    public void save(GenConfigEntity saveEntity) {
        GenConfig genConfig = GenConfigConvertor.toDO(saveEntity);
        int count = StringUtils.isNullOrEmpty(saveEntity.getId()) ? genConfigMapper.insert(genConfig) : genConfigMapper.updateById(genConfig);
    }
}
