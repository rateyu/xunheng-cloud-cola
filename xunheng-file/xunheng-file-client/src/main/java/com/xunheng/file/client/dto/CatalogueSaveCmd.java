package com.xunheng.file.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CatalogueSaveCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @NotBlank(message = "目录名称不能为空")
    @ApiModelProperty(value = "目录名称")
    private String title;

    @NotBlank(message = "目录路径不能为空")
    @ApiModelProperty(value = "目录路径")
    private String dir;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;
}
