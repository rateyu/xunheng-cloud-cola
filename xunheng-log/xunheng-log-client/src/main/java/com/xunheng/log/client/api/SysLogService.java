package com.xunheng.log.client.api;

import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.log.client.dto.VO.LogVO;
import com.xunheng.log.client.dto.query.LogPageQuery;
import org.springframework.data.domain.Page;
import java.util.Map;

/**
 * @program: xunheng-cloud-cola
 * @description: 系统日志service接口
 * @author: hhqkkr
 * @date: 2023/6/29 17:37
 */
public interface SysLogService {

    /**
     * 日志分页列表查询
     * @param query 日志分页查询
     * @return 日志分页列表
     */
    Page<LogVO> pageList(LogPageQuery query);

    /**
     * 获取日志echart数据
     */
    Map<String, Object> getEchartsData();

    /**
     * 删除日志
     * @param id 日志id
     */
    void remove(String id);

    /**
     * 删除所有日志
     */
    void removeAll();

    /**
     * 日志保存数据
     * @param cmd 日志创建操作
     * @return 日志VO
     */
    LogVO save(LogCreateCmd cmd);
}
