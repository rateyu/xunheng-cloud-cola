package com.xunheng.quartz.domain.ability;

import com.xunheng.quartz.domain.model.QuartzJobEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: quartz领域服务接口
 * @author: hhqkkr
 * @date: 2023/6/29 18:11
 */
public interface QuartzDomainService {

    /**
     * quartz新增
     */
    void create(QuartzJobEntity entity);

    /**
     * quartz更新
     */
    void update(QuartzJobEntity entity);

    /**
     * quartz删除
     * @param id 任务id
     * @param isUpdate 是否是更新操作
     */
    void remove(String id,Boolean isUpdate);

    /**
     * quartz 恢复
     * @param id 任务id
     */
    void resume(String id);

    /**
     * quartz 暂停
     * @param id 任务id
     */
    void pause(String id);

    /**
     * quartz 执行一次
     * @param id 任务id
     */
    void executeOnce(String id);

}
