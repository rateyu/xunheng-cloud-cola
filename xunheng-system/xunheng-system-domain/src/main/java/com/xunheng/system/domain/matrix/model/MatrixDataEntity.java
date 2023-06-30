package com.xunheng.system.domain.matrix.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class MatrixDataEntity {

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
