package com.xunheng.security.config.annotation;

import com.xunheng.security.config.CommonSaTokenConfiguration;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * @program: xunheng-cloud-cola
 * @description: mvc包的依赖 添加satoken配置
 * @author: hhqkkr
 * @date: 2023/6/29 17:24
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CommonSaTokenConfiguration.class)
public @interface XhMvc
{
}
