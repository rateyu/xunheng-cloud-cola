package com.xunheng.quartz.app.executor;

import com.xunheng.quartz.domain.ability.QuartzDomainService;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务暂停操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 18:02
 */
@Component
public class QuartzJobPauseCmdExe {

    @Resource
    private QuartzDomainService quartzDomainService;

    public void execute(String id){
        quartzDomainService.pause(id);
    }
}
