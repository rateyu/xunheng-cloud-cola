package com.xunheng.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: xunheng-cloud-cola
 * @description: 小程序controller方法的权限码 用于校验功能权限
 * @author: hhqkkr
 * @date: 2023/6/29 14:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface WmaPermissionCode
{
    /**
     * 需要校验的权限码
     */
    String[] value() default {};
}
