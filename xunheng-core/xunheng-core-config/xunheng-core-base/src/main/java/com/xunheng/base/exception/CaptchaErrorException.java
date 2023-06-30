package com.xunheng.base.exception;

import lombok.Data;


/**
 * @program: xunheng-cloud-cola
 * @description: 验证码校验错误异常
 * @author: hhqkkr
 * @create: 2021-12-16 23:13
 */
@Data
public class CaptchaErrorException extends RuntimeException {

    private String msg;

    public CaptchaErrorException(String msg){
        super(msg);
        this.msg = msg;
    }

    public CaptchaErrorException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }
}
