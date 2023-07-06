package com.xunheng.generator.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GenFrontConfigFieldVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "字段描述")
    private String description;

    @ApiModelProperty(value = "字段类型")
    private String type;

    @ApiModelProperty(value = "表格列宽度")
    private int colWidth;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "api地址")
    private String api;

    @ApiModelProperty(value = "是否为搜索条件 0:否 1:是")
    private Integer searchable;

    @ApiModelProperty(value = "查询条件类型")
    private String searchType;

}
