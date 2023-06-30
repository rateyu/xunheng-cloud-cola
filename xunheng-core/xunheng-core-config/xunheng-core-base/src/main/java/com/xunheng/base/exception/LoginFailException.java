package com.xunheng.base.exception;

import lombok.Data;


/**
 * @program: xunheng-cloud-cola
 * @description: 登录错误异常
 * @author: hhqkkr
 * @create: 2021-12-16 23:13
 */
@Data
public class LoginFailException extends RuntimeException {

    private String msg;

    public LoginFailException(String msg){
        super(msg);
        this.msg = msg;
    }

    public LoginFailException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }
}
