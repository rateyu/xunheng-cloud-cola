package com.xunheng.security.config.aop;

import com.xunheng.base.exception.FeignBadRequestException;
import com.xunheng.base.annotation.FeignAPI;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @program: xunheng-cloud-cola
 * @description: feign切面 捕捉feign异常
 * @author: hhqkkr
 * @create: 2021-12-31 12:58
 */
@Slf4j
@Aspect
@Component
public class FeignApiAspect implements Ordered {

    @Around(value = "@annotation(feignAPI) || @within(feignAPI)")
    Object around4Method(ProceedingJoinPoint joinPoint, FeignAPI feignAPI) throws Throwable{
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
            log.error("fegin服务端内部异常");
            throw new FeignBadRequestException(throwable.getMessage());
        }
        return proceed;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}
