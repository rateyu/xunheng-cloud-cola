package com.xunheng.system.domain.dict.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class DictDataEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "数据名称")
    private String title;

    @ApiModelProperty(value = "数据值")
    private String value;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "所属字典")
    private DictEntity dictEntity;
}
