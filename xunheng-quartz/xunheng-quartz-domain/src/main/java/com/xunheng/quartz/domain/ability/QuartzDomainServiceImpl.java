package com.xunheng.quartz.domain.ability;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.constant.ScheduleConstant;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.quartz.domain.model.QuartzJobEntity;
import com.xunheng.quartz.domain.gateway.QuartzJobGateway;
import com.xunheng.quartz.domain.model.QuartzJobLogEntity;
import com.xunheng.quartz.domain.gateway.QuartzJobLogGateway;
import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: quartz领域服务实现
 * @author: hhqkkr
 * @date: 2023/6/29 18:11
 */
@Service
public class QuartzDomainServiceImpl implements QuartzDomainService {

    @Resource
    private QuartzJobGateway quartzJobGateway;

    @Resource
    private QuartzJobLogGateway quartzJobLogGateway;

    @Resource
    private Scheduler scheduler;

    @Override
    public void create(QuartzJobEntity entity) {
        try {
            /*先保存任务信息 填充id*/
            entity = quartzJobGateway.saveOrUpdate(entity);
            String jobClassName = entity.getJobClassName();
            String cronExpression = entity.getCronExpression();
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(ScheduleConstant.JOB_DATA_KEY, entity);
            Class<?> class1 = Class.forName(jobClassName);
            Job job = (Job) class1.newInstance();
            /*构建JobDetail*/
            JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                    .withIdentity(jobClassName)
                    .setJobData(dataMap)
                    .build();
            /*按新的cronExpression表达式构建一个新的trigger*/
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobClassName)
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing())
                    .build();
            /*启动调度器*/
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            throw  new GlobalException("创建定时任务失败 SchedulerException " + e);
        } catch (ClassNotFoundException e) {
            throw  new GlobalException("创建定时任务失败 找不到对应的class " + e);
        } catch (InstantiationException e) {
            throw  new GlobalException("创建定时任务失败 InstantiationException " + e);
        } catch (IllegalAccessException e) {
            throw  new GlobalException("创建定时任务失败 IllegalAccessException " + e);
        }
    }

    @Override
    public void update(QuartzJobEntity entity) {
        /*先删除scheduler信息 再重新创建*/
        remove(entity.getId(),true);
        create(entity);
    }

    @Override
    public void remove(String id,Boolean isUpdate) {
        try {
            QuartzJobEntity quartzJob = quartzJobGateway.getOne(id);
            String jobClassName = quartzJob.getJobClassName();
            scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName));
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName));
            scheduler.deleteJob(JobKey.jobKey(jobClassName));
            if(!isUpdate)quartzJobGateway.remove(quartzJob.getId());//如果是更新的操作 不删除实体
        } catch (SchedulerException e) {
            throw new GlobalException("删除定时任务失败");
        }
    }

    @Override
    public void resume(String id) {
        try {
            QuartzJobEntity quartzJob = quartzJobGateway.getOne(id);
            scheduler.resumeJob(JobKey.jobKey(quartzJob.getJobClassName()));
            quartzJob.setStatus(CommonConstant.STATUS_NORMAL);
            quartzJobGateway.saveOrUpdate(quartzJob);
        } catch (SchedulerException e) {
            throw new GlobalException("恢复定时任务失败");
        }
    }

    @Override
    public void pause(String id) {
        try {
            QuartzJobEntity quartzJob = quartzJobGateway.getOne(id);
            scheduler.pauseJob(JobKey.jobKey(quartzJob.getJobClassName()));
            quartzJob.setStatus(CommonConstant.STATUS_DISABLE);
            quartzJobGateway.saveOrUpdate(quartzJob);
        } catch (SchedulerException e) {
            throw new GlobalException("暂停定时任务失败");
        }
    }

    @Override
    public void executeOnce(String id) {
        try {
            Date startDate = new Date();
            QuartzJobEntity quartzJob = quartzJobGateway.getOne(id);
            scheduler.triggerJob(JobKey.jobKey(quartzJob.getJobClassName()));
            //保存执行日志
            QuartzJobLogEntity entity = new QuartzJobLogEntity();
            entity.setJobId(quartzJob.getId());
            entity.setStartTime(startDate);
            entity.setStopTime(new Date());
            long runMs = entity.getStopTime().getTime() - entity.getStartTime().getTime();
            entity.setJobMessage(quartzJob.getDescription() + " 总共耗时：" + runMs + "毫秒");
            entity.setStatus(0);
            quartzJobLogGateway.saveOrUpdate(entity);
        } catch (Exception e) {
            throw  new GlobalException("执行一次任务失败" + e);
        }
    }

}
