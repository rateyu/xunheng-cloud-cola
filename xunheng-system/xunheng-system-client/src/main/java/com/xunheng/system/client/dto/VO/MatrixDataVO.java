package com.xunheng.system.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MatrixDataVO {

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
