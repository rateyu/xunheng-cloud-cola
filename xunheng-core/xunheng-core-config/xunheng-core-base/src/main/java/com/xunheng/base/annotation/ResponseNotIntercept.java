package com.xunheng.base.annotation;

import java.lang.annotation.*;

/**
 * @program: xunheng-cloud-cola
 * @description: 标记一些不需要统一返回处理的方法或类
 * @author: hhqkkr
 * @date: 2023/6/29 14:07
 */
@Target({ElementType.METHOD, ElementType.TYPE})  //可以在字段、方法
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseNotIntercept {
    String value() default "";
}