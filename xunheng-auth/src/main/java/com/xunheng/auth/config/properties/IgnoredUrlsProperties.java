package com.xunheng.auth.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 鉴权忽略地址配置
 * @author: hhqkkr
 * @date: 2023/6/29 13:01
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ignored")
@RefreshScope
public class IgnoredUrlsProperties {

    private List<String> urls = new ArrayList<>();
}