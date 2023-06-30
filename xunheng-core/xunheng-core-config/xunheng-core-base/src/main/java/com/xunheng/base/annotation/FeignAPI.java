package com.xunheng.base.annotation;

import java.lang.annotation.*;

/**
 * @program: xunheng-cloud-cola
 * @description: FeignAPI注解 表示feign客户端会访问的api
 * @author: hhqkkr
 * @date: 2023/6/29 14:06
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@PermissionCode("none")
public @interface FeignAPI {

    int httpStatus() default 503;

}
