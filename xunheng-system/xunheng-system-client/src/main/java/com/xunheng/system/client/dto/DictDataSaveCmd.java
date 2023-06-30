package com.xunheng.system.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class DictDataSaveCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @NotBlank(message = "数据名称不能为空")
    @ApiModelProperty(value = "数据名称")
    private String title;

    @NotBlank(message = "数据值不能为空")
    @ApiModelProperty(value = "数据值")
    private String value;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "所属字典")
    private String dictId;

    @ApiModelProperty(value = "所属字典类型")
    private String type;

    @ApiModelProperty(value = "所属字典名称")
    private String dictTitle;

}
