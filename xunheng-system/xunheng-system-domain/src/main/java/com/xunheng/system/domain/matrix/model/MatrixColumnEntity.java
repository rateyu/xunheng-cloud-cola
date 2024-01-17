package com.xunheng.system.domain.matrix.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class MatrixColumnEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "矩阵id")
    private String matrixId;

    @Schema(description = "名称")
    private String title;

    @Schema(description = "标识名")
    private String tag;

    @Schema(description = "列类型")
    private String type;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "列矩阵值")
    private List<MatrixDataEntity> matrixData;

}
