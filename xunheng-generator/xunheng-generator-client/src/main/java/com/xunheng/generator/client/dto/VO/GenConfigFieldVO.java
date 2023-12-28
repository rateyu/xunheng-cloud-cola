package com.xunheng.generator.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GenConfigFieldVO {

    @Schema(description = "id")
    private String id;

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
