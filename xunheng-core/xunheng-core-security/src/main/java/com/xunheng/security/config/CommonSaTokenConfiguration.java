package com.xunheng.security.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: xunheng-cloud-cola
 * @description: satoken配置
 * @author: hhqkkr
 * @create: 2022-01-14 14:14
 */
@Configuration
public class CommonSaTokenConfiguration implements WebMvcConfigurer {

    /**
     * 拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }
}
