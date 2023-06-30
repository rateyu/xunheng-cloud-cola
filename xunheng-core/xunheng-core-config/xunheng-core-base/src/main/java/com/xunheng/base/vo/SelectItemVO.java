package com.xunheng.base.vo;

import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 前端select项
 * @author: hhqkkr
 * @date: 2023/6/29 14:19
 */
@Data
public class SelectItemVO {

    /**
     * id
     */
    String id;

    /**
     * 名称
     */
    String title;

    /**
     * 值
     */
    String value;

    /**
     * 描述
     */
    String description;
}
