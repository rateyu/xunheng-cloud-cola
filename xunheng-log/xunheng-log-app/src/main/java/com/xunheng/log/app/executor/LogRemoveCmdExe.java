package com.xunheng.log.app.executor;

import com.xunheng.log.domain.log.LogGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志删除操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 17:45
 */
@Component
public class LogRemoveCmdExe {

    @Resource
    private LogGateway logGateway;

    /**
     * @param id 日志id
     */
    public void execute(String id){
        logGateway.remove(id);
    }
}
