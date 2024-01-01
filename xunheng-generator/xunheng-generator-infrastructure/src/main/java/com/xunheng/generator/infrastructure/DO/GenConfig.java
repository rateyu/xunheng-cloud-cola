package com.xunheng.generator.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@TableName("g_gen_config")
@Schema(description = "代码生成设置")
@Table
public class GenConfig extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "类型 mvc cola")
    private String type;

    @Schema(description = "实体名")
    private String name;

    @Schema(description = "领域名称")
    private String domainName;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "作者")
    private String author;

    @Schema(description = "表名前缀")
    private String tablePrefix;

    @Schema(description = "表名简称")
    private String tableAlias;

    @Schema(description = "服务名")
    private String serviceName;

}
