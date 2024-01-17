package com.xunheng.quartz.app.executor;

import com.xunheng.quartz.app.assembler.QuartzJobAssembler;
import com.xunheng.quartz.client.dto.QuartzJobCreateCmd;
import com.xunheng.quartz.domain.ability.QuartzDomainService;
import com.xunheng.quartz.domain.model.QuartzJobEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务新增操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 18:02
 */
@Component
public class QuartzJobCreateCmdExe {

    @Resource
    private QuartzDomainService quartzDomainService;

    public void execute(QuartzJobCreateCmd cmd){
        QuartzJobEntity entity = QuartzJobAssembler.toCreateEntity(cmd);
        quartzDomainService.create(entity);
    }

}
