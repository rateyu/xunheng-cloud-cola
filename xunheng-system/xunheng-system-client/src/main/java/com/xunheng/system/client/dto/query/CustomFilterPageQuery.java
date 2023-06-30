package com.xunheng.system.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class CustomFilterPageQuery extends PageDto {

    @ApiModelProperty(value = "自定义过滤条件")
    private String customCondition;
}
