package com.xunheng.quartz.app.assembler;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.quartz.client.dto.QuartzJobCreateCmd;
import com.xunheng.quartz.client.dto.QuartzJobUpdateCmd;
import com.xunheng.quartz.client.dto.VO.QuartzJobVO;
import com.xunheng.quartz.domain.model.QuartzJobEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 18:00
 */
public class QuartzJobAssembler {

    public static QuartzJobEntity toCreateEntity(QuartzJobCreateCmd cmd){
        QuartzJobEntity entity = new QuartzJobEntity();
        entity.setJobClassName(cmd.getJobClassName());
        entity.setCronExpression(cmd.getCronExpression());
        entity.setParameter(cmd.getParameter());
        entity.setDescription(cmd.getDescription());
        entity.setStatus(CommonConstant.STATUS_NORMAL);
        return entity;
    }

    public static QuartzJobEntity toUpdateEntity(QuartzJobUpdateCmd cmd){
        QuartzJobEntity entity = new QuartzJobEntity();
        entity.setId(cmd.getId());
        entity.setJobClassName(cmd.getJobClassName());
        entity.setCronExpression(cmd.getCronExpression());
        entity.setParameter(cmd.getParameter());
        entity.setDescription(cmd.getDescription());
        entity.setStatus(CommonConstant.STATUS_NORMAL);
        return entity;
    }

    public static QuartzJobVO toVO(QuartzJobEntity entity){
        QuartzJobVO vo = new QuartzJobVO();
        vo.setId(entity.getId());
        vo.setJobClassName(entity.getJobClassName());
        vo.setCronExpression(entity.getCronExpression());
        vo.setParameter(entity.getParameter());
        vo.setDescription(entity.getDescription());
        vo.setStatus(entity.getStatus());
        return vo;
    }

}
