package com.xunheng.log.app.assembler;

import com.xunheng.base.utils.DateUtil;
import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.log.client.dto.VO.LogVO;
import com.xunheng.log.domain.log.LogEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志DTO转换
 * @author: hhqkkr
 * @date: 2023/6/29 17:40
 */
public class LogAssembler {

    public static LogEntity toEntity(LogCreateCmd cmd){
        LogEntity entity = new LogEntity();
        entity.setId(cmd.getId());
        entity.setModule(cmd.getModule());
        entity.setTitle(cmd.getTitle());
        entity.setBusinessType(cmd.getBusinessType());
        entity.setBusinessTypes(cmd.getBusinessTypes());
        entity.setMethod(cmd.getMethod());
        entity.setRequestMethod(cmd.getRequestMethod());
        entity.setOperName(cmd.getOperName());
        entity.setDepartmentTitle(cmd.getDepartmentTitle());
        entity.setTenantTitle(cmd.getTenantTitle());
        entity.setOperUrl(cmd.getOperUrl());
        entity.setOperIp(cmd.getOperIp());
        entity.setOperParam(cmd.getOperParam());
        entity.setResultStr(cmd.getResultStr());
        entity.setStatus(cmd.getStatus());
        entity.setErrorMsg(cmd.getErrorMsg());
        entity.setOperTime(DateUtil.dateFormatToStr(DateUtil.DATE_TIME_FORMAT2,cmd.getOperTime()));
        entity.setOperTimeMillis(cmd.getOperTimeMillis());
        return entity;
    }

    public static LogVO toVo(LogEntity entity){
        LogVO vo = new LogVO();
        vo.setId(entity.getId());
        vo.setModule(entity.getModule());
        vo.setTitle(entity.getTitle());
        vo.setBusinessType(entity.getBusinessType());
        vo.setMethod(entity.getMethod());
        vo.setRequestMethod(entity.getRequestMethod());
        vo.setOperName(entity.getOperName());
        vo.setDepartmentTitle(entity.getDepartmentTitle());
        vo.setTenantTitle(entity.getTenantTitle());
        vo.setOperUrl(entity.getOperUrl());
        vo.setOperIp(entity.getOperIp());
        vo.setOperParam(entity.getOperParam());
        vo.setResultStr(entity.getResultStr());
        vo.setStatus(entity.getStatus());
        vo.setErrorMsg(entity.getErrorMsg());
        vo.setOperTime(DateUtil.dateFormat(DateUtil.DATE_TIME_FORMAT2,entity.getOperTime()));
        vo.setOperTimeMillis(entity.getOperTimeMillis());
        return vo;
    }
}
