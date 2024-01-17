package com.xunheng.file.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CatalogueSaveCmd {

    @Schema(description = "id")
    private String id;

    @NotBlank(message = "目录名称不能为空")
    @Schema(description = "目录名称")
    private String title;

    @NotBlank(message = "目录路径不能为空")
    @Schema(description = "目录路径")
    private String dir;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;
}
