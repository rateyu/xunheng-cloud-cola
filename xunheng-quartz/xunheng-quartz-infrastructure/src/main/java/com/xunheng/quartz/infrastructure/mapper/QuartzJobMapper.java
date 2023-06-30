package com.xunheng.quartz.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunheng.quartz.infrastructure.DO.QuartzJob;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: xunheng
 * @description:
 * @author: hhqkkr
 * @create: 2022-01-04 17:49
 */
@Repository
public interface QuartzJobMapper extends BaseMapper<QuartzJob> {
        /**
         * 获取所有计划任务
         * @return 任务列表
         */
        List<QuartzJob> getAll();
}