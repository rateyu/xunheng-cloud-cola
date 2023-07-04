package com.xunheng.generator.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GenConfigFieldVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "字段描述")
    private String description;

    @ApiModelProperty(value = "字段类型")
    private String type;

    @ApiModelProperty(value = "默认值")
    private String defaultVal;

    @ApiModelProperty(value = "是否索引 0:否 1:是")
    private Integer cindex;

    @ApiModelProperty(value = "是否不能为空 0:否 1:是")
    private Integer notNull;
}
