package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 矩阵列
 * @author hhqkkr
 * @date 2022-07-28 16:06:45
 */
@Data
@TableName("sys_matrix_column")
@Schema(description = "矩阵列")
@Table
public class MatrixColumn extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "矩阵id")
    private String matrixId;

    @Schema(description = "标识名")
    private String tag;

    @Schema(description = "名称")
    private String title;

    @Schema(description = "列类型")
    private String type;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

}