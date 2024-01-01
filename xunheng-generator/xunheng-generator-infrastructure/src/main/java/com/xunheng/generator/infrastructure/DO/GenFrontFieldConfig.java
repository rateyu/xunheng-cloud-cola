package com.xunheng.generator.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("g_gen_front_field_config")
@Schema(description = "代码生成前端字段设置")
@Table
public class GenFrontFieldConfig extends BaseNoneLogicDO {

    @Schema(description = "字段名称")
    private String fieldName;

    @Schema(description = "字段描述")
    private String description;

    @Schema(description = "字段类型")
    private String type;

    @Schema(description = "表格列宽度")
    private int colWidth;

    @Schema(description = "字典类型")
    private String dictType;

    @Schema(description = "api地址")
    private String api;

    @Schema(description = "是否为搜索条件 0:否 1:是")
    private Integer searchable;

    @Schema(description = "查询条件类型")
    private String searchType;
}
