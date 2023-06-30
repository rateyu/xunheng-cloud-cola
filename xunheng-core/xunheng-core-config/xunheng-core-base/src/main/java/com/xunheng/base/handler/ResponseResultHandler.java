package com.xunheng.base.handler;

import com.alibaba.fastjson.JSON;
import com.xunheng.base.annotation.ResponseNotIntercept;
import com.xunheng.base.utils.ResultUtil;
import com.xunheng.base.vo.ResultVO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: xunheng-cloud-cola
 * @description: 统一返回逻辑处理
 * @author: hhqkkr
 * @date: 2023/6/29 14:15
 */
@RestControllerAdvice
@ConditionalOnClass(ResponseBodyAdvice.class)
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //若在类中加了@ResponseNotIntercept 则该类中的方法不用做统一的拦截
        //若方法上加了@ResponseNotIntercept 则该方法不用做统一的拦截
        if(returnType.getDeclaringClass().isAnnotationPresent(ResponseNotIntercept.class) ||
                returnType.getMethod().isAnnotationPresent(ResponseNotIntercept.class)
        ) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ResultVO)return body;//如果body已经被包装了，就不进行包装
        if (body instanceof  String)return JSON.toJSONString(new ResultUtil<>().setSuccessMsg(body.toString()));//String得返回成json
        return new ResultUtil<>().setData(body);
    }
}
