package com.xunheng.log.config.annotation;

import com.xunheng.base.enums.BusinessType;
import java.lang.annotation.*;

/**
 * @program: xunheng-cloud-cola
 * @description: 自定义操作日志记录注解
 * @author: hhqkkr
 * @date: 2023/6/29 17:14
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    /**
     * 功能模块
     */
    public String module() default "";

    /**
     * 功能详情
     */
    public String title() default "";

    /**
     * 功能类别
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;
}
