package com.xunheng.log.app.executor;

import com.xunheng.log.domain.log.LogGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志全部删除操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 17:45
 */
@Component
public class LogRemoveAllCmdExe {
    @Resource
    private LogGateway logGateway;

    public void execute(){
        logGateway.removeAll();
    }
}
