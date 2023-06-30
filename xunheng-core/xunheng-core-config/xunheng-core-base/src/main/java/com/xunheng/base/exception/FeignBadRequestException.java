package com.xunheng.base.exception;

/**
 * @program: xunheng-cloud-cola
 * @description: 自定义Feign异常
 * @author: hhqkkr
 * @create: 2021-12-30 23:05
 */
public class FeignBadRequestException extends RuntimeException {

    // 自定义异常代码
    private int status = 503;
    // 构造方法
    public FeignBadRequestException(String message, int status) {
        super(message);
        this.status = status;
    }

    public FeignBadRequestException(String message) {
        super(message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
