package com.xunheng.log.config;

import com.plumelog.core.TraceIdFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @program: xunheng-cloud-cola
 * @description: plumelog配置
 * @author: hhqkkr
 * @create: 2022-01-05 22:40
 */
@Configuration
public class PlumeLogFilterConfig {


    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(initCustomFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(Integer.MIN_VALUE);
        return filterRegistrationBean;
    }

    @Bean
    public Filter initCustomFilter() {
        return new TraceIdFilter();
    }
}
