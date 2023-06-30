package com.xunheng.system.domain.matrix.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class MatrixColumnEntity {

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

    @ApiModelProperty(value = "列矩阵值")
    private List<MatrixDataEntity> matrixData;

}
