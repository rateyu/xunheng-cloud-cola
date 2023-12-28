package com.xunheng.generator.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("g_gen_field_config")
@Schema(description = "代码生成字段设置")
@Table
public class GenFieldConfig extends BaseNoneLogicDO {

    @Schema(description = "字段名称")
    private String fieldName;

    @Schema(description = "字段描述")
    private String description;

    @Schema(description = "字段类型")
    private String type;

    @Schema(description = "默认值")
    private String defaultVal;

    @Schema(description = "是否索引 0:否 1:是")
    private Integer cindex;

    @Schema(description = "是否不能为空 0:否 1:是")
    private Integer notNull;

}
