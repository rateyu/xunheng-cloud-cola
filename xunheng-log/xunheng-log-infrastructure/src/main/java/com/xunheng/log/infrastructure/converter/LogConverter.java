package com.xunheng.log.infrastructure.converter;

import com.xunheng.base.utils.SnowFlakeUtil;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.log.domain.log.LogEntity;
import com.xunheng.log.infrastructure.DO.EsLogDO;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志DO转换
 * @author: hhqkkr
 * @date: 2023/6/29 17:49
 */
public class LogConverter {

    public static EsLogDO toDB(LogEntity entity){
        EsLogDO db = new EsLogDO();
        db.setId(String.valueOf(SnowFlakeUtil.nextId()));
        db.setModule(entity.getModule());
        db.setTitle(entity.getTitle());
        db.setBusinessType(entity.getBusinessType());
        db.setBusinessTypes(entity.getBusinessTypes());
        db.setMethod(entity.getMethod());
        db.setRequestMethod(entity.getRequestMethod());
        db.setOperName(entity.getOperName());
        db.setDepartmentTitle(entity.getDepartmentTitle());
        db.setTenantTitle(entity.getTenantTitle());
        db.setOperUrl(entity.getOperUrl());
        db.setOperIp(entity.getOperIp());
        db.setOperParam(entity.getOperParam());
        db.setResultStr(entity.getResultStr());
        db.setStatus(entity.getStatus());
        db.setErrorMsg(entity.getErrorMsg());
        db.setOperTime(entity.getOperTime());
        db.setOperTimeMillis(entity.getOperTimeMillis());
        return db;
    }

    public static LogEntity toEntity(EsLogDO db){
        LogEntity entity = new LogEntity();
        entity.setId(db.getId());
        entity.setModule(db.getModule());
        entity.setTitle(db.getTitle());
        entity.setBusinessType(db.getBusinessType());
        entity.setBusinessTypes(db.getBusinessTypes());
        entity.setMethod(db.getMethod());
        entity.setRequestMethod(db.getRequestMethod());
        entity.setOperName(db.getOperName());
        entity.setDepartmentTitle(db.getDepartmentTitle());
        entity.setTenantTitle(db.getTenantTitle());
        entity.setOperUrl(db.getOperUrl());
        entity.setOperIp(db.getOperIp());
        entity.setOperParam(db.getOperParam());
        entity.setResultStr(db.getResultStr());
        entity.setStatus(db.getStatus());
        entity.setErrorMsg(db.getErrorMsg());
        entity.setOperTime(db.getOperTime());
        entity.setOperTimeMillis(db.getOperTimeMillis());
        return entity;
    }
}
