package com.xunheng.log.config.tlog;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.yomahub.tlog")
public class LogConfig {

    @Bean
    public FilterRegistrationBean<TLogFilter> loggingFilter() {
        FilterRegistrationBean<TLogFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TLogFilter());
        registrationBean.addUrlPatterns("/*"); // 拦截所有请求路径
        return registrationBean;
    }
}
