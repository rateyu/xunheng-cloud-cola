package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class DictSaveCmd {

    @Schema(description = "id")
    private String id;

    @NotBlank(message = "字典名称不能为空")
    @Schema(description = "字典名称")
    private String title;

    @NotBlank(message = "字典类型不能为空")
    @Schema(description = "字典类型")
    private String type;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

}
