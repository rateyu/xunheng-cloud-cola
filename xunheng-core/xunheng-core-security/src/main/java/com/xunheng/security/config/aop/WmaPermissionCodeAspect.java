package com.xunheng.security.config.aop;

import com.xunheng.base.annotation.WmaPermissionCode;
import com.xunheng.base.utils.StpWmaUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @program: xunheng-cloud-cola
 * @description: 小程序客户端权限码数据权限切面 小程序相关功能使用WmaPermissionCode这个注解
 * @author: hhqkkr
 * @create: 2022-01-10 17:35
 */
@Aspect
@Component
public class WmaPermissionCodeAspect {

    @Before("@annotation(code)")
    public void doBefore(JoinPoint point, WmaPermissionCode code) throws Throwable
    {
        StpWmaUtil.checkLogin();
    }


}
