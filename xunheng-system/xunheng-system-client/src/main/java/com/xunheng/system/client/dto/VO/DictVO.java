package com.xunheng.system.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DictVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "字典名称")
    private String title;

    @ApiModelProperty(value = "字典类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;
}
