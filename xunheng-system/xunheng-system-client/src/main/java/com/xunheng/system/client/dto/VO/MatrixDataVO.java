package com.xunheng.system.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MatrixDataVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "矩阵id")
    private String matrixId;

    @ApiModelProperty(value = "矩阵列标识")
    private String columnTag;

    @ApiModelProperty(value = "矩阵行id")
    private String rowId;

    @ApiModelProperty(value = "矩阵数据")
    private String data;


}
