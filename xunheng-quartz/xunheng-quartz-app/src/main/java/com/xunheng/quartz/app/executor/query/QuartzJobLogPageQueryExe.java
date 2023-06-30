package com.xunheng.quartz.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.quartz.app.assembler.QuartzJobLogAssembler;
import com.xunheng.quartz.client.dto.VO.QuartzJobLogVO;
import com.xunheng.quartz.client.dto.query.QuartzJobLogPageQuery;
import com.xunheng.quartz.domain.model.QuartzJobLogEntity;
import com.xunheng.quartz.domain.gateway.QuartzJobLogGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务日志分页查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 18:02
 */
@Component
public class QuartzJobLogPageQueryExe {

    @Resource
    QuartzJobLogGateway quartzJobLogGateway;

    public IPage<QuartzJobLogVO> execute(QuartzJobLogPageQuery query){
        IPage<QuartzJobLogEntity> page = quartzJobLogGateway.pageList(query);
        return page.convert(QuartzJobLogAssembler::toVO);
    }
}
