package com.xunheng.log.config.fallback;

import com.xunheng.log.client.api.BaseFeignLogService;
import com.xunheng.log.client.dto.LogCreateCmd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志api异常处理
 * @author: hhqkkr
 * @create: 2021-12-27 15:55
 */
@Slf4j
@Component
public class LogFallback implements BaseFeignLogService {

    @Override
    public void save(LogCreateCmd cmd) {
        log.info("日志服务未开启。。。");
    }
}
