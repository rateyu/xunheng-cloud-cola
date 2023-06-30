package com.xunheng.auth.domain.config.saToken;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.xunheng.auth.domain.config.properties.IgnoredUrlsProperties;
import com.xunheng.base.exception.TenantExpireException;
import com.xunheng.base.utils.ResultUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description:  网关Sa-Token全局过滤器配置
 * @author: hhqkkr
 * @create: 2021-12-16 01:17
 */
@Configuration
public class GatewaySaTokenConfiguration {

    @Resource
    private IgnoredUrlsProperties ignoredUrlsProperties;

    @Bean
    public SaReactorFilter getSaReactorFilter(){
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                // 忽略的地址
                .addExclude(excludeUrls())
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由
                    SaRouter.match("/**", "", r -> StpUtil.checkLogin());
                })
                // 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> {
                    String message;
                    int code = 500;
                    if (e instanceof NotLoginException) {//如果是未登录异常
                        NotLoginException ee = (NotLoginException) e;
                        String type = ee.getType();
                        code = 401;
                        message = "您已被登出或无权限访问当前资源，请尝试重新登录后再操作。"+type;
                    }else if(e instanceof NotRoleException) {// 如果是角色异常
                        message = "对不起，您没有当前权限！";
                    }else if(e instanceof NotPermissionException) {//如果是权限异常
                        message = "对不起，您没有当前权限！";
                    }else if(e instanceof DisableLoginException) {//如果是被封禁异常
                        message = "此账号禁止登录！";
                    }else if (e instanceof TenantExpireException) {//如果是授权过期异常
                        TenantExpireException ee = (TenantExpireException) e;
                        code = 401;
                        message = ee.getMessage();
                    }else{
                        message = e.getMessage();
                    }
                    return JSON.toJSON(new ResultUtil<>().setErrorMsg(code, message));
                });
    }

    private String[] excludeUrls(){
        //获取忽略鉴权的urls
        List<String> urls = ignoredUrlsProperties.getUrls();
        return urls.toArray(new String[urls.size()]);
    }
}
