package com.xunheng.quartz.app.executor.query;

import com.xunheng.quartz.app.assembler.QuartzJobAssembler;
import com.xunheng.quartz.client.dto.VO.QuartzJobVO;
import com.xunheng.quartz.domain.model.QuartzJobEntity;
import com.xunheng.quartz.domain.gateway.QuartzJobGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务列表查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 18:02
 */
@Component
public class QuartzJobListAllQueryExe {

    @Resource
    private QuartzJobGateway quartzJobGateway;

    public List<QuartzJobVO> execute(){
        List<QuartzJobEntity> list =  quartzJobGateway.getAll();
        return list.stream().map(QuartzJobAssembler::toVO).collect(Collectors.toList());
    }
}
