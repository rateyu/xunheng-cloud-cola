package com.xunheng.quartz.app.executor;

import com.xunheng.quartz.app.assembler.QuartzJobLogAssembler;
import com.xunheng.quartz.client.dto.QuartzJobLogCreateCmd;
import com.xunheng.quartz.domain.model.QuartzJobLogEntity;
import com.xunheng.quartz.domain.gateway.QuartzJobLogGateway;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务日志新增操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 18:02
 */
@Component
public class QuartzJobLogCreateCmdExe {

    @Resource
    private QuartzJobLogGateway quartzJobLogGateway;

    public void execute(QuartzJobLogCreateCmd cmd){
        QuartzJobLogEntity entity = QuartzJobLogAssembler.toEntity(cmd);
        quartzJobLogGateway.saveOrUpdate(entity);
    }

}
