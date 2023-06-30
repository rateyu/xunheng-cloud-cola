package com.xunheng.system.client.dto;

import com.xunheng.system.client.dto.VO.MatrixColumnVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MatrixColumnSaveCmd {

    @ApiModelProperty(value = "矩阵id")
    private String id;

    @ApiModelProperty(value = "列字段列表")
    private List<MatrixColumnVO> columnList;

}
