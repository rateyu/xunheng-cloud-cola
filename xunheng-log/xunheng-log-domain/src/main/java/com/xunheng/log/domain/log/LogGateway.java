package com.xunheng.log.domain.log;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志网关接口
 * @author: hhqkkr
 * @date: 2023/6/29 17:47
 */
public interface LogGateway {

    /**
     * 获取日志分页信息
     * @param queryCondition 查询条件
     * @return 日志分页列表
     */
    Page<LogEntity> pageList(NativeSearchQuery queryCondition);

    /**
     * 根据时间区间获取日志信息
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 日志列表
     */
    List<LogEntity> findByOperTimeMillisBetween(long startTime, long endTime);

    /**
     * 日志保存
     * @param entity 日志实体
     * @return 日志实体
     */
    LogEntity save(LogEntity entity);

    /**
     * 日志删除
     * @param id 日志id
     */
    void remove(String id);

    /**
     * 日志删除所有
     */
    void removeAll();

}
