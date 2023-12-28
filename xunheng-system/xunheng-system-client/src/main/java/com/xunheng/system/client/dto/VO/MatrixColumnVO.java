package com.xunheng.system.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MatrixColumnVO {

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

}
