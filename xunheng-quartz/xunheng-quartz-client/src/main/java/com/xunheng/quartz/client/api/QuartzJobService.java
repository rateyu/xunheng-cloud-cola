package com.xunheng.quartz.client.api;

import com.xunheng.quartz.client.dto.QuartzJobCreateCmd;
import com.xunheng.quartz.client.dto.QuartzJobUpdateCmd;
import com.xunheng.quartz.client.dto.VO.QuartzJobVO;
import io.seata.spring.annotation.GlobalTransactional;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 任务service接口
 * @author: hhqkkr
 * @date: 2023/6/29 17:55
 */
public interface QuartzJobService {

    /**
     * 获取所有计划任务
     * @return 任务列表
     */
    List<QuartzJobVO> getAll();

    /**
     * 新增计划任务
     * @param cmd 新增操作dto
     */
    void create(QuartzJobCreateCmd cmd);

    /**
     * 暂停
     * @param id 任务id
     */
    void pause(String id);

    /**
     * 恢复
     * @param id 任务id
     */
    void resume(String id);

    /**
     * 更新计划任务
     * @param cmd 更新操作dto
     */
    void update(QuartzJobUpdateCmd cmd);

    /**
     * 删除
     * @param id 任务id
     */
    void remove(String id);

    /**
     * 执行一次
     * @param id 任务id
     */
    void executeOnce(String id);


}
