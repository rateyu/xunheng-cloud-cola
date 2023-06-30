package com.xunheng.auth.domain.config.plumeLog;

import com.plumelog.core.webflux.WebFluxTraceIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: xunheng-cloud-cola
 * @description: 网关处plumelog配置 网关是webflux需要单独配置
 * @author: hhqkkr
 * @date: 2023/6/29 13:00
 */
@Configuration
public class PlumeLogGatewayFilterConfig {

    @Bean
    public WebFluxTraceIdFilter initCustomFilter(){
        return new WebFluxTraceIdFilter();
    }

}