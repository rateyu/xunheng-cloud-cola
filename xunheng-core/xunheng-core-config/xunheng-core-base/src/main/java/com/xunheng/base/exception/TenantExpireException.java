package com.xunheng.base.exception;

import lombok.Data;


/**
 * @program: xunheng-cloud-cola
 * @description: 授权过期异常
 * @author: hhqkkr
 * @create: 2021-12-16 23:13
 */
@Data
public class TenantExpireException extends RuntimeException {

    private String msg;

    public TenantExpireException(String msg){
        super(msg);
        this.msg = msg;
    }

    public TenantExpireException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }
}
