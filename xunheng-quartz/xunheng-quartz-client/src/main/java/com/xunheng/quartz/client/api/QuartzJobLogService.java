package com.xunheng.quartz.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.quartz.client.dto.QuartzJobLogCreateCmd;
import com.xunheng.quartz.client.dto.VO.QuartzJobLogVO;
import com.xunheng.quartz.client.dto.query.QuartzJobLogPageQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: xunheng-cloud-cola
 * @description: 任务操作日志service接口
 * @author: hhqkkr
 * @date: 2023/6/29 17:54
 */
public interface QuartzJobLogService
{
    /**
     * 任务执行日志分页
     * @param query 任务执行日志分页查询dto
     * @return 任务执行日志分页列表
     */
    IPage<QuartzJobLogVO> pageList(QuartzJobLogPageQuery query);

    /**
     * 任务执行日志新增
     * @param cmd 新增操作dto
     */
    void create(QuartzJobLogCreateCmd cmd);
}
