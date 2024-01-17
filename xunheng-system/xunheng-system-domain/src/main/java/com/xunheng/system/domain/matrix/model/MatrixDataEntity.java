package com.xunheng.system.domain.matrix.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class MatrixDataEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "矩阵id")
    private String matrixId;

    @Schema(description = "矩阵列标识")
    private String columnTag;

    @Schema(description = "矩阵行id")
    private String rowId;

    @Schema(description = "矩阵数据")
    private String data;

}
