package com.xunheng.log.app.executor;

import com.xunheng.log.app.assembler.LogAssembler;
import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.log.client.dto.VO.LogVO;
import com.xunheng.log.domain.log.LogEntity;
import com.xunheng.log.domain.log.LogGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志创建操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 17:45
 */
@Component
public class LogCreateCmdExe {

    @Resource
    private LogGateway logGateway;

    public LogVO execute(LogCreateCmd cmd){
        LogEntity entity =  logGateway.save(LogAssembler.toEntity(cmd));
        return LogAssembler.toVo(entity);
    }
}
