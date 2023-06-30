package com.xunheng.quartz.app.assembler;

import com.xunheng.quartz.client.dto.QuartzJobLogCreateCmd;
import com.xunheng.quartz.client.dto.VO.QuartzJobLogVO;
import com.xunheng.quartz.domain.model.QuartzJobLogEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务日志dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 18:01
 */
public class QuartzJobLogAssembler {

    public static QuartzJobLogEntity toEntity(QuartzJobLogCreateCmd cmd){
        QuartzJobLogEntity entity = new QuartzJobLogEntity();
        entity.setId(cmd.getId());
        entity.setJobId(cmd.getJobId());
        entity.setJobMessage(cmd.getJobMessage());
        entity.setExceptionInfo(cmd.getExceptionInfo());
        entity.setStartTime(cmd.getStartTime());
        entity.setStopTime(cmd.getStopTime());
        entity.setStatus(cmd.getStatus());
        return entity;
    }

    public static QuartzJobLogVO toVO(QuartzJobLogEntity entity){
        QuartzJobLogVO vo = new QuartzJobLogVO();
        vo.setId(entity.getId());
        vo.setJobMessage(entity.getJobMessage());
        vo.setExceptionInfo(entity.getExceptionInfo());
        vo.setStartTime(entity.getStartTime());
        vo.setStatus(entity.getStatus());
        return vo;
    }

}
