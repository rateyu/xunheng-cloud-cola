package com.xunheng.feign.interceptor;

import cn.dev33.satoken.stp.StpUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @program: xunheng-cloud-cola
 * @description: feign拦截器 每一次请求添加token
 * @author: hhqkkr
 * @create: 2022-01-10 01:33
 */
@Configuration
public class FeignAuthInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(StpUtil.getTokenName(), StpUtil.getTokenValue());
    }
}
