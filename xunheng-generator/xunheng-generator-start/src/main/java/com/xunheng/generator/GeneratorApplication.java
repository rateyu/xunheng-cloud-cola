package com.xunheng.generator;

import com.tangzc.mpe.actable.EnableAutoTable;
import com.xunheng.feign.annotation.EnableXhFeignClients;
import com.xunheng.security.config.annotation.XhMvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xunheng", "com.alibaba.cola"})
@EnableXhFeignClients
@EnableAutoTable
@XhMvc
public class GeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }
}
