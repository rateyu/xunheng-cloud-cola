package com.xunheng.base.exception;

/**
 * @program: xunheng-cloud-cola
 * @description: 全局通用异常
 * @author: hhqkkr
 * @create: 2021-12-13 23:57
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误提示
     */
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public GlobalException(String msg){
        super(msg);
        this.msg = msg;
    }
}
