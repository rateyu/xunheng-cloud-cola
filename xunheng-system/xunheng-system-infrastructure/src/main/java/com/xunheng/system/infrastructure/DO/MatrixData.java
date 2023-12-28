package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 矩阵数据
 * @author hhqkkr
 * @date 2022-07-28 16:09:01
 */
@Data
@TableName("sys_matrix_data")
@Schema(description = "矩阵数据")
@Table
public class MatrixData extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "矩阵id")
    private String matrixId;

    @Schema(description = "矩阵列标识")
    private String columnTag;

    @Schema(description = "矩阵行id")
    private String rowId;

    @Schema(description = "矩阵数据")
    private String data;

}