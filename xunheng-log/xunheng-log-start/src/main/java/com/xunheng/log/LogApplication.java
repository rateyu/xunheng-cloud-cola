package com.xunheng.log;

import com.xunheng.feign.annotation.EnableXhFeignClients;
import com.xunheng.security.config.annotation.XhMvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(scanBasePackages = {"com.xunheng", "com.alibaba.cola"})
@EnableXhFeignClients
@XhMvc
@EnableElasticsearchRepositories(basePackages = "com.xunheng")
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }
}
