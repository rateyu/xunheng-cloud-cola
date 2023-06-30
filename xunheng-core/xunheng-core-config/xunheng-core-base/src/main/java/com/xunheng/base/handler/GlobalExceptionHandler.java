package com.xunheng.base.handler;

import com.xunheng.base.exception.*;
import com.xunheng.base.utils.ResultUtil;
import com.xunheng.base.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: xunheng-cloud-cola
 * @description: 统一异常处理
 * @author: hhqkkr
 * @date: 2023/6/29 14:13
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * feign调用异常
     */
    @ExceptionHandler(FeignBadRequestException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    public ResultVO<Object> handleFeignBadRequestException(Exception e) {
        String errorMsg="FeignBadRequestException";
        if (e!=null){
            errorMsg = e.getMessage();
            log.error(e.toString(), e);
        }
        return new ResultUtil<>().setErrorMsg(503, errorMsg);
    }

    /**
     * 全局通用异常
     */
    @ExceptionHandler(GlobalException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResultVO<Object> handleGlobalException(GlobalException e) {

        String errorMsg="xunheng exception";
        if (e!=null){
            errorMsg = e.getMsg();
            log.error(e.toString(), e);
        }
        return new ResultUtil<>().setErrorMsg(500, errorMsg);
    }

    /**
     * 其他异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResultVO<String> handleException(Exception e) {
        if (e instanceof CaptchaErrorException) {//验证码失败异常
            CaptchaErrorException ee = (CaptchaErrorException) e;
            return new ResultUtil<String>().setErrorMsg(500, ee.getMessage());
        }else if (e instanceof LoginFailException) {//登录失败异常
            LoginFailException ee = (LoginFailException) e;
            return new ResultUtil<String>().setErrorMsg(500, ee.getMessage());
        }else if(e instanceof LoginDisableException) {//登录禁用异常
            LoginDisableException ee = (LoginDisableException) e;
            return new ResultUtil<String>().setErrorMsg(500, ee.getMessage());
        }
        /*else if(e instanceof RetryableException) {//feign超时异常
            return new ResultUtil<String>().setErrorMsg(500, "系统开小差了，请稍后再试002");
        }*/
        else if(e instanceof FeignBadRequestException) {//自定义的feign异常
            FeignBadRequestException ee = (FeignBadRequestException) e;
            return new ResultUtil<String>().setErrorMsg(500, ee.getMessage());
        }else if(e instanceof TenantExpireException) {//授权过期异常
            TenantExpireException ee = (TenantExpireException) e;
            return new ResultUtil<String>().setErrorMsg(500, ee.getMessage());
        }
        /*else if(e instanceof NotPermissionException) {//无此权限异常
            return new ResultUtil<String>().setErrorMsg(500, "您没有当前操作的权限！");
        }*/
        else if(e instanceof BindException) {//参数校验异常 取第一个返回
            BindException be = (BindException)e;
            ObjectError objectError = be.getBindingResult().getAllErrors().get(0);
            return new ResultUtil<String>().setErrorMsg(500,objectError.getDefaultMessage());
        }else if(e instanceof MethodArgumentNotValidException) {//参数校验异常 取第一个返回
            MethodArgumentNotValidException be = (MethodArgumentNotValidException)e;
            ObjectError objectError = be.getBindingResult().getAllErrors().get(0);
            return new ResultUtil<String>().setErrorMsg(500,objectError.getDefaultMessage());
        }else{
            String message = e.getMessage();
            if(message != null && message.indexOf("Load balancer does not have available server for client:") != -1) {
                log.error(message.split("Load balancer does not have available server for client:")[1]+"服务已下线");
                return new ResultUtil<String>().setErrorMsg(500, "系统开小差了，请稍后再试 service unavailable");
            }else {
                // 打印堆栈，以供调试
                e.printStackTrace();
                return new ResultUtil<String>().setErrorMsg(500, e.getMessage());
            }
        }
    }
}

