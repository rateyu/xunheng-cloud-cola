package com.xunheng.feign.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;


import java.lang.annotation.*;

/**
 * @program: xunheng-cloud-cola
 * @description: 自定义feign注解 添加basePackages路径
 * @author: hhqkkr
 * @date: 2023/6/29 16:34
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableXhFeignClients
{
    String[] value() default {};

    String[] basePackages() default { "com.xunheng.*" };

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
