package com.xunheng.auth.infrastructure.rpc;


import com.xunheng.base.constant.ServiceNameConstant;
import com.xunheng.log.client.dto.LogCreateCmd;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: xunheng-cloud-cola
 * @description: log服务api
 * @author: hhqkkr
 * @create: 2021-12-28 17:56
 */
@FeignClient(contextId = "feignLogService",
        fallback = LogFallback.class,
        value = ServiceNameConstant.LOG_SERVICE,
        path = "/sysLog")
public interface FeignLogService
{
    /**
     * 保存日志
     * @param cmd 日志DTO
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    void save(@RequestBody LogCreateCmd cmd);
}