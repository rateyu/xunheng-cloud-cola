package com.xunheng.generator.domain.genConfig.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.base.exception.GlobalException;
import io.seata.common.util.StringUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
public class GenFrontFieldConfigEntity {

    @Schema(description = "id")
    private String id;

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
