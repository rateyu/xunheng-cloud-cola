package com.xunheng.system.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class DictSaveCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @NotBlank(message = "字典名称不能为空")
    @ApiModelProperty(value = "字典名称")
    private String title;

    @NotBlank(message = "字典类型不能为空")
    @ApiModelProperty(value = "字典类型")
    private String type;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

}
