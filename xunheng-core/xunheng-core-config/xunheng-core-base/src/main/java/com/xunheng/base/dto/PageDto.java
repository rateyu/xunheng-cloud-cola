package com.xunheng.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "页号 默认 1")
    private int page = 1;

    @Schema(description = "页面大小 默认10")
    private int pageSize = 10;
}
