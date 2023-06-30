package com.xunheng.quartz.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.quartz.client.dto.query.QuartzJobLogPageQuery;
import com.xunheng.quartz.infrastructure.DO.QuartzJobLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng
 * @description:
 * @author: hhqkkr
 * @create: 2022-01-04 17:49
 */
@Repository
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLog> {

        /**
         * 计划任务日志分页
         */
        IPage<QuartzJobLog> pageList(Page<QuartzJobLog> page, @Param("qry") QuartzJobLogPageQuery query);

}