package com.xunheng.quartz.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.quartz.client.dto.query.QuartzJobLogPageQuery;
import com.xunheng.quartz.domain.model.QuartzJobLogEntity;
import com.xunheng.quartz.domain.gateway.QuartzJobLogGateway;
import com.xunheng.quartz.infrastructure.DO.QuartzJobLog;
import com.xunheng.quartz.infrastructure.converter.QuartzJobLogConverter;
import com.xunheng.quartz.infrastructure.mapper.QuartzJobLogMapper;
import io.seata.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuartzJobLogGatewayImpl implements QuartzJobLogGateway {

    @Autowired
    QuartzJobLogMapper quartzJobLogMapper;

    @Override
    public IPage<QuartzJobLogEntity> pageList(QuartzJobLogPageQuery query) {
        IPage<QuartzJobLog> page = quartzJobLogMapper.pageList(new Page<QuartzJobLog>(query.getPage(), query.getPageSize()), query);
        return page.convert(QuartzJobLogConverter::toEntity);
    }

    @Override
    public void saveOrUpdate(QuartzJobLogEntity entity) {
        QuartzJobLog quartzJobLog = QuartzJobLogConverter.toDO(entity);
        int count = StringUtils.isNullOrEmpty(quartzJobLog.getId()) ? quartzJobLogMapper.insert(quartzJobLog) : quartzJobLogMapper.updateById(quartzJobLog);
    }

}
