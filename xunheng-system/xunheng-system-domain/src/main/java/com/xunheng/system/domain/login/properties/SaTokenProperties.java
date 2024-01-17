package com.xunheng.system.domain.login.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @program: xunheng-cloud-cola
 * @description: 网关登陆satoken相关配置
 * @author: hhqkkr
 * @date: 2023/6/29 13:02
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sa-token")
@RefreshScope
public class SaTokenProperties {

    /**
     * 限制用户登陆错误次数（次）
     */
    private Integer loginTimeLimit = 10;

    /**
     * 错误次数保留的时间（小时）
     */
    private Integer loginFailCountKeepTime = 24;

    /**
     * 错误超过次数后多少分钟后才能继续登录（分钟）
     */
    private Integer loginAfterTime = 10;
}
