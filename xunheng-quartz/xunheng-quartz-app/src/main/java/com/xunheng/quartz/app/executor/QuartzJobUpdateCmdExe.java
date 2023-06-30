package com.xunheng.quartz.app.executor;

import com.xunheng.quartz.app.assembler.QuartzJobAssembler;
import com.xunheng.quartz.client.dto.QuartzJobUpdateCmd;
import com.xunheng.quartz.domain.ability.QuartzDomainService;
import com.xunheng.quartz.domain.model.QuartzJobEntity;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务更新操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 18:02
 */
@Component
public class QuartzJobUpdateCmdExe {

    @Resource
    private QuartzDomainService quartzDomainService;

    public void execute(QuartzJobUpdateCmd cmd){
        QuartzJobEntity entity = QuartzJobAssembler.toUpdateEntity(cmd);
        quartzDomainService.update(entity);
    }
}
