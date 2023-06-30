package com.xunheng.quartz.infrastructure.gateway.impl;

import com.xunheng.quartz.infrastructure.DO.QuartzJob;
import com.xunheng.quartz.infrastructure.converter.QuartzJobConverter;
import com.xunheng.quartz.infrastructure.mapper.QuartzJobMapper;
import com.xunheng.quartz.domain.model.QuartzJobEntity;
import com.xunheng.quartz.domain.gateway.QuartzJobGateway;
import io.seata.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务网关实现类
 * @author: hhqkkr
 * @date: 2023/6/29 18:26
 */
@Component
public class QuartzJobGatewayImpl implements QuartzJobGateway {

    @Autowired
    QuartzJobMapper quartzJobMapper;

    @Override
    public List<QuartzJobEntity> getAll() {
        List<QuartzJob> list = quartzJobMapper.getAll();
        return list.stream().map(QuartzJobConverter::toEntity).collect(Collectors.toList());
    }

    @Override
    public QuartzJobEntity saveOrUpdate(QuartzJobEntity entity) {
        QuartzJob quartzJob = QuartzJobConverter.toDO(entity);
        int count = StringUtils.isNullOrEmpty(quartzJob.getId()) ? quartzJobMapper.insert(quartzJob) : quartzJobMapper.updateById(quartzJob);
        return QuartzJobConverter.toEntity(quartzJob);
    }

    @Override
    public QuartzJobEntity getOne(String id) {
        QuartzJob quartzJob = quartzJobMapper.selectById(id);
        return QuartzJobConverter.toEntity(quartzJob);
    }

    @Override
    public void remove(String id) {
        quartzJobMapper.deleteById(id);
    }
}
