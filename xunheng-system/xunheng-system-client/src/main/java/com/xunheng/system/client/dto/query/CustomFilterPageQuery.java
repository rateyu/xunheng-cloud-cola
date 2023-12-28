package com.xunheng.system.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public abstract class CustomFilterPageQuery extends PageDto {

    @Schema(description = "自定义过滤条件")
    private String customCondition;
}
