package com.xunheng.system.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DictVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "字典名称")
    private String title;

    @Schema(description = "字典类型")
    private String type;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;
}
