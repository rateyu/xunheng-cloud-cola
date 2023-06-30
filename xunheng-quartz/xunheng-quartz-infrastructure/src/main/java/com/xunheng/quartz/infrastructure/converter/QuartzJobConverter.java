package com.xunheng.quartz.infrastructure.converter;

import com.xunheng.quartz.domain.model.QuartzJobEntity;
import com.xunheng.quartz.infrastructure.DO.QuartzJob;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务DO转换
 * @author: hhqkkr
 * @date: 2023/6/29 18:25
 */
public class QuartzJobConverter {

    public static QuartzJob toDO(QuartzJobEntity entity){
        QuartzJob db = new QuartzJob();
        db.setId(entity.getId());
        db.setJobClassName(entity.getJobClassName());
        db.setCronExpression(entity.getCronExpression());
        db.setParameter(entity.getParameter());
        db.setDescription(entity.getDescription());
        db.setStatus(entity.getStatus());
        return db;
    }

    public static QuartzJobEntity toEntity(QuartzJob db){
        QuartzJobEntity entity = new QuartzJobEntity();
        entity.setId(db.getId());
        entity.setJobClassName(db.getJobClassName());
        entity.setCronExpression(db.getCronExpression());
        entity.setParameter(db.getParameter());
        entity.setDescription(db.getDescription());
        entity.setStatus(db.getStatus());
        return entity;
    }
}
