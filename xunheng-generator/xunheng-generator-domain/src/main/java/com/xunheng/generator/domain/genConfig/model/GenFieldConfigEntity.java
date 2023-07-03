package com.xunheng.generator.domain.genConfig.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class GenFieldConfigEntity {

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
}
