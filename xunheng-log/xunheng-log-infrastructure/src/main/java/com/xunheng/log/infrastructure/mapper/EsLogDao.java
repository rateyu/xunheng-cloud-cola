package com.xunheng.log.infrastructure.mapper;

import com.xunheng.log.infrastructure.DO.EsLogDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志数据层
 * @author: hhqkkr
 * @date: 2023/6/29 17:50
 */
@Repository
public interface EsLogDao extends ElasticsearchRepository<EsLogDO, String> {

    /**
     * 根据时间区间查询日志
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return 日志列表
     */
    List<EsLogDO> findByOperTimeMillisBetween(Long startDate, Long endDate);
}
