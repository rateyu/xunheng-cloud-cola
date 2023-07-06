package com.xunheng.generator.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("g_gen_front_field_config")
@ApiModel(value = "代码生成前端字段设置")
@Table
public class GenFrontFieldConfig extends BaseNoneLogicDO {

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
