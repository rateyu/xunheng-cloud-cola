package com.xunheng.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.generator.domain.genConfig.gateway.GenConfigGateway;
import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;
import com.xunheng.infrastructure.DO.GenConfig;
import com.xunheng.infrastructure.convertor.GenConfigConvertor;
import com.xunheng.infrastructure.mapper.GenConfigMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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

    }
}
