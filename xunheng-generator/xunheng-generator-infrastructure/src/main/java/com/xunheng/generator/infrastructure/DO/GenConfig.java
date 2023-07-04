package com.xunheng.generator.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@TableName("g_gen_config")
@ApiModel(value = "代码生成设置")
@Table
public class GenConfig extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型 mvc cola")
    private String type;

    @ApiModelProperty(value = "实体名")
    private String name;

    @ApiModelProperty(value = "领域名称")
    private String domainName;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "表名前缀")
    private String tablePrefix;

    @ApiModelProperty(value = "表名简称")
    private String tableAlias;

    @ApiModelProperty(value = "服务名")
    private String serviceName;

}
