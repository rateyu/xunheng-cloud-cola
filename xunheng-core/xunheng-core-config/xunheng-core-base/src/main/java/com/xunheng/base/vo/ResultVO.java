package com.xunheng.base.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author hhqkkr
 * 前后端交互数据标准
 */
@Data
public class ResultVO<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T data;

}
