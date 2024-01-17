package com.xunheng.generator.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class GenConfigVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "类型")
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

    @Schema(description = "表字段")
    private List<GenConfigFieldVO> fieldList;

    @Schema(description = "前端展示字段")
    private List<GenFrontConfigFieldVO> frontFieldList;
}
