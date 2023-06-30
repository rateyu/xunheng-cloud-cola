package com.xunheng.auth;

import cn.dev33.satoken.SaManager;
import com.xunheng.base.config.SwaggerConfig;
import com.xunheng.feign.annotation.EnableXhFeignClients;
import com.xunheng.log.config.PlumeLogFilterConfig;
import com.xunheng.redis.config.RedisConfig;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: AuthApplication
 * @author: hhqkkr
 * @create: 2021-12-14 11:48
 */
@SpringBootApplication(exclude = {PlumeLogFilterConfig.class, SwaggerConfig.class, RedisConfig.class})
@EnableXhFeignClients
public class AuthApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AuthApplication.class, args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }

    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }
}
