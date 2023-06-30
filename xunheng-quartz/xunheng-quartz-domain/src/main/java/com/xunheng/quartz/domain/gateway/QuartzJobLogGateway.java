package com.xunheng.quartz.domain.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.quartz.client.dto.query.QuartzJobLogPageQuery;
import com.xunheng.quartz.domain.model.QuartzJobLogEntity;

public interface QuartzJobLogGateway {

    /**
     * 任务执行日志分页
     * @param query 分页查询dto
     * @return 分页列表
     */
    IPage<QuartzJobLogEntity> pageList(QuartzJobLogPageQuery query);

    /**
     * 保存或更新任务执行日志
     * @param entity 日志实体
     */
    void saveOrUpdate(QuartzJobLogEntity entity);

}
