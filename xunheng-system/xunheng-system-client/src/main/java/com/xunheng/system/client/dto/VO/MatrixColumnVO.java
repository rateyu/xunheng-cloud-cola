package com.xunheng.system.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MatrixColumnVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "矩阵id")
    private String matrixId;

    @ApiModelProperty(value = "名称")
    private String title;

    @ApiModelProperty(value = "标识名")
    private String tag;

    @ApiModelProperty(value = "列类型")
    private String type;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

}
