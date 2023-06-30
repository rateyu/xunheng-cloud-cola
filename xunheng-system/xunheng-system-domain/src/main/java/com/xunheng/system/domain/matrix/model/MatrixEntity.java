package com.xunheng.system.domain.matrix.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class MatrixEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "矩阵列")
    private List<MatrixColumnEntity> matrixColumn;

}
