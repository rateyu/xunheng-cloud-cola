package com.xunheng.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("g_gen_field_config")
@ApiModel(value = "代码生成字段设置")
@Table
public class GenFieldConfig extends BaseNoneLogicDO {

    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    @ApiModelProperty(value = "字段描述")
    private String description;

    @ApiModelProperty(value = "字段类型")
    private String type;

    @ApiModelProperty(value = "默认值")
    private String defaultVal;

}
