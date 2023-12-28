package com.xunheng.system.domain.matrix.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class MatrixEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "矩阵列")
    private List<MatrixColumnEntity> matrixColumn;

}
