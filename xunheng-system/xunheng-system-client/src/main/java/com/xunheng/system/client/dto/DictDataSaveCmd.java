package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class DictDataSaveCmd {

    @Schema(description = "id")
    private String id;

    @NotBlank(message = "数据名称不能为空")
    @Schema(description = "数据名称")
    private String title;

    @NotBlank(message = "数据值不能为空")
    @Schema(description = "数据值")
    private String value;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "所属字典")
    private String dictId;

    @Schema(description = "所属字典类型")
    private String type;

    @Schema(description = "所属字典名称")
    private String dictTitle;

}
