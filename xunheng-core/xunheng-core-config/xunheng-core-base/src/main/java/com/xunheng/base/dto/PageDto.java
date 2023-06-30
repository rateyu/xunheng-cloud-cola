package com.xunheng.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: xunheng-cloud-cola
 * @description: 通用分页DTO
 * @author: hhqkkr
 * @date: 2023/6/29 14:11
 */
@Data
public class PageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "页号 默认 1")
    private int page = 1;

    @ApiModelProperty(value = "页面大小 默认10")
    private int pageSize = 10;
}
