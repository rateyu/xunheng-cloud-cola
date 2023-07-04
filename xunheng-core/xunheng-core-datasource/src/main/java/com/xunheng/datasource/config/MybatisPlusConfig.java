package com.xunheng.datasource.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.xunheng.datasource.config.handler.DataPermissionHandler;
import com.xunheng.datasource.config.interceptor.DataPermissionInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: mybatisplus配置
 * @author: hhqkkr
 * @date: 2023/6/29 17:09
 */
@Configuration
@MapperScan({"com.xunheng.*.infrastructure.mapper","com.xunheng.*.dao.mapper"})
public class MybatisPlusConfig {

    @Resource
    DataPermissionHandler dataPermissionHandler;

    /**
     * 多租户与数据拦截 分页拦截
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 数据权限插件
        interceptor.addInnerInterceptor(new DataPermissionInterceptor(dataPermissionHandler));
        //自定义条件过滤插件 未开源
        //interceptor.addInnerInterceptor(new CustomFilterInterceptor());
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
