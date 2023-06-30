package com.xunheng.feign.config;

import com.alibaba.fastjson.JSONObject;
import com.xunheng.base.exception.GlobalException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 统一处理feign异常
 * @author: hhqkkr
 * @create: 2021-12-30 23:03
 */
@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        log.error("捕获到fegin服务端内部异常");
        if(response.status() != HttpStatus.OK.value()){
            if(response.status() == HttpStatus.SERVICE_UNAVAILABLE.value()){
                String errContent;
                GlobalException exception = new GlobalException("内部请求异常");
                try {
                    errContent = Util.toString(response.body().asReader());
                    if(!StringUtils.isEmpty(errContent)){
                        errContent = errContent.replaceAll("\t","").replaceAll("\n","");
                        JSONObject errResp = JSONObject.parseObject(errContent);
                        String errMessage = errResp.getString("message");
                        exception = new GlobalException(errMessage);
                    }
                }catch (Exception e){
                    log.error("feign处理异常错误",e);
                }
                return exception;
            }
        }
        return new GlobalException("未知错误！");
    }
}
