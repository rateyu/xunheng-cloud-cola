package com.xunheng.system.client.dto;

import com.xunheng.system.client.dto.VO.MatrixColumnVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class MatrixColumnSaveCmd {

    @Schema(description = "矩阵id")
    private String id;

    @Schema(description = "列字段列表")
    private List<MatrixColumnVO> columnList;

}
