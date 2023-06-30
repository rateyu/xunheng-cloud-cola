package com.xunheng.quartz.app.job;

import com.xunheng.base.constant.ScheduleConstant;
import com.xunheng.base.utils.ExceptionUtil;
import com.xunheng.base.utils.SnowFlakeUtil;
import com.xunheng.base.utils.SpringUtils;
import com.xunheng.quartz.client.dto.QuartzJobLogCreateCmd;
import com.xunheng.quartz.client.api.QuartzJobLogService;
import com.xunheng.quartz.infrastructure.DO.QuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: quartz任务抽象
 * @author: hhqkkr
 * @date: 2023/6/29 18:06
 */
@Slf4j
public abstract class AbstractQuartzJob implements Job{

    /**
     * 线程本地变量
     */
    private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    /**
     * 执行
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException{
        QuartzJob quartzJob = new QuartzJob();
        BeanUtils.copyProperties( context.getMergedJobDataMap().get(ScheduleConstant.JOB_DATA_KEY),quartzJob);
        try{
            before(context, quartzJob);
            doExecute(context, quartzJob);
            after(context, quartzJob, null);
        }catch (Exception e){
            log.error("任务执行异常  - ：", e);
            after(context, quartzJob, e);
        }
    }

    /**
     * 执行前
     * @param context 工作执行上下文对象
     * @param quartzJob 系统计划任务
     */
    protected void before(JobExecutionContext context, QuartzJob quartzJob)
    {
        threadLocal.set(new Date());
    }

    /**
     * 执行后 保存执行日志
     * @param context 工作执行上下文对象
     * @param quartzJob 系统计划任务
     */
    protected void after(JobExecutionContext context, QuartzJob quartzJob, Exception e){
        Date startTime = threadLocal.get();
        threadLocal.remove();
        final QuartzJobLogCreateCmd cmd = new QuartzJobLogCreateCmd();
        cmd.setJobId(quartzJob.getId());
        cmd.setStartTime(startTime);
        cmd.setStopTime(new Date());
        long runMs = cmd.getStopTime().getTime() - cmd.getStartTime().getTime();
        cmd.setJobMessage(quartzJob.getDescription() + " 总共耗时：" + runMs + "毫秒");
        if (e != null){
            cmd.setStatus(-1);
            String errorMsg = StringUtils.substring(ExceptionUtil.getExceptionMessage(e), 0, 2000);
            cmd.setExceptionInfo(errorMsg);
        }else{
            cmd.setStatus(0);
        }
        // 写入数据库当中
        SpringUtils.getBean(QuartzJobLogService.class).create(cmd);
    }

    /**
     * 执行方法，由子类重载
     * @param context 工作执行上下文对象
     * @param quartzJob 系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, QuartzJob quartzJob) throws Exception;
}
