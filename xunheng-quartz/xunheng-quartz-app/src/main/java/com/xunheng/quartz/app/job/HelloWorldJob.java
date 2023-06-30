package com.xunheng.quartz.app.job;

import cn.hutool.core.date.DateUtil;
import com.xunheng.quartz.app.job.AbstractQuartzJob;
import com.xunheng.quartz.infrastructure.DO.QuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;

/**
 * @program: xunheng
 * @description: hello world示例
 * @author: hhqkkr
 * @create: 2022-01-04 17:37
 */
@Slf4j
public class HelloWorldJob extends AbstractQuartzJob {

    @Override
    protected void doExecute(JobExecutionContext context, QuartzJob quartzJob) throws Exception {
        log.info("Hello World : " + DateUtil.now());
    }
}