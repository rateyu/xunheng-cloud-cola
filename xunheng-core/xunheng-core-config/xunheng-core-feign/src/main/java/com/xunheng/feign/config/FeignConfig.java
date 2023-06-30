
package com.xunheng.feign.config;

import com.xunheng.feign.interceptor.FeignAuthInterceptor;
import feign.Logger;
import feign.Request;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: xunheng-cloud-cola
 * @description: feign配置
 * @author: hhqkkr
 * @create: 2021-12-26 15:17
 */
@Slf4j
@Configuration
public class FeignConfig {

    @Bean
    public Request.Options options(){
        return new Request.Options(5000,10000);
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignClientErrorDecoder();
    }

    @Bean
    public FeignAuthInterceptor feignAuthRequestInterceptor(){
        return new FeignAuthInterceptor();
    }

}

