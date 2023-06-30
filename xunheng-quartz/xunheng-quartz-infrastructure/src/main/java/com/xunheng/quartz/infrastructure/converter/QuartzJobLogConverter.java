package com.xunheng.quartz.infrastructure.converter;

import com.xunheng.quartz.domain.model.QuartzJobLogEntity;
import com.xunheng.quartz.infrastructure.DO.QuartzJobLog;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务执行日志DO转换
 * @author: hhqkkr
 * @date: 2023/6/29 18:25
 */
public class QuartzJobLogConverter {

    public static QuartzJobLog toDO(QuartzJobLogEntity entity){
        QuartzJobLog db = new QuartzJobLog();
        db.setId(entity.getId());
        db.setCreateTime(entity.getCreateTime());
        db.setJobId(entity.getJobId());
        db.setJobMessage(entity.getJobMessage());
        db.setExceptionInfo(entity.getExceptionInfo());
        db.setStartTime(entity.getStartTime());
        db.setStopTime(entity.getStopTime());
        db.setStatus(entity.getStatus());
        return db;
    }

    public static QuartzJobLogEntity toEntity(QuartzJobLog db){
        QuartzJobLogEntity entity = new QuartzJobLogEntity();
        entity.setId(db.getId());
        entity.setCreateTime(db.getCreateTime());
        entity.setJobId(db.getJobId());
        entity.setJobMessage(db.getJobMessage());
        entity.setExceptionInfo(db.getExceptionInfo());
        entity.setStartTime(db.getStartTime());
        entity.setStopTime(db.getStopTime());
        entity.setStatus(db.getStatus());
        return entity;
    }
}
