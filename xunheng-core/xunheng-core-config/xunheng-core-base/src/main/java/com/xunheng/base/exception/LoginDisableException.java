package com.xunheng.base.exception;

import lombok.Data;


/**
 * @program: xunheng-cloud-cola
 * @description: 登录禁用异常
 * @author: hhqkkr
 * @create: 2021-12-16 23:13
 */
@Data
public class LoginDisableException extends RuntimeException {

    private String msg;

    public LoginDisableException(String msg){
        super(msg);
        this.msg = msg;
    }

    public LoginDisableException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }
}
