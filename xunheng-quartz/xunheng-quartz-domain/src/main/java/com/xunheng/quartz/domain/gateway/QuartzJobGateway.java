package com.xunheng.quartz.domain.gateway;

import com.xunheng.quartz.domain.model.QuartzJobEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务网关
 * @author: hhqkkr
 * @date: 2023/6/29 18:21
 */
public interface QuartzJobGateway {

    /**
     * 获取所有任务
     * @return 任务列表
     */
    List<QuartzJobEntity> getAll();

    /**
     * 保存或更新任务
     * @param entity 任务实体
     * @return 任务实体
     */
    QuartzJobEntity saveOrUpdate(QuartzJobEntity entity);

    /**
     * 根据id获取任务实体
     * @param id 任务id
     * @return 任务实体
     */
    QuartzJobEntity getOne(String id);

    /**
     * 删除任务
     * @param id 任务id
     */
    void remove(String id);
}
