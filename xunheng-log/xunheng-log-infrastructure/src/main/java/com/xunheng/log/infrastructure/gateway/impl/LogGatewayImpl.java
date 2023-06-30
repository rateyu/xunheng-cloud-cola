package com.xunheng.log.infrastructure.gateway.impl;

import com.xunheng.log.domain.log.LogEntity;
import com.xunheng.log.domain.log.LogGateway;
import com.xunheng.log.infrastructure.DO.EsLogDO;
import com.xunheng.log.infrastructure.converter.LogConverter;
import com.xunheng.log.infrastructure.mapper.EsLogDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志网关实现类
 * @author: hhqkkr
 * @date: 2023/6/29 17:50
 */
@Service
@Slf4j
public class LogGatewayImpl implements LogGateway {

    @Autowired(required = false)
    private EsLogDao logDao;

    @Override
    public Page<LogEntity> pageList(NativeSearchQuery queryCondition) {
        Page<EsLogDO> page = logDao.search(queryCondition);
        List<LogEntity> collect = page.getContent().stream().map(LogConverter::toEntity).collect(Collectors.toList());
        return new PageImpl<>(collect, page.getPageable(), page.getTotalElements());
    }

    @Override
    public List<LogEntity> findByOperTimeMillisBetween(long startTime, long endTime) {
        List<EsLogDO> logs = logDao.findByOperTimeMillisBetween(startTime, endTime);
        return logs.stream().map(LogConverter::toEntity).collect(Collectors.toList());
    }

    @Override
    public LogEntity save(LogEntity entity) {
        EsLogDO esLogDO = logDao.save(LogConverter.toDB(entity));
        return LogConverter.toEntity(esLogDO);
    }

    @Override
    public void remove(String id) {
        logDao.deleteById(id);
    }

    @Override
    public void removeAll() {
        logDao.deleteAll();
    }


}
