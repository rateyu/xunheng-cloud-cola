package com.xunheng.base.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: xunheng-cloud-cola
 * @description: swagger配置
 * @author: hhqkkr
 * @create: 2022-01-05 12:18
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.xunheng.*.adapter.web","com.xunheng.*.controller",})
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xunheng-cloud-cola")
                .description("xunheng-cloud-cola swagger")
                .version("1.0")
                .contact(new Contact("hhqkkr", "http://www.xunheng.cloud", "452794162@qq.com"))
                .licenseUrl("127.0.0.1")
                .build();
    }

}
