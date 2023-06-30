package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 矩阵列
 * @author hhqkkr
 * @date 2022-07-28 16:06:45
 */
@Data
@TableName("sys_matrix_column")
@ApiModel(value = "矩阵列")
@Table
public class MatrixColumn extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "矩阵id")
    private String matrixId;

    @ApiModelProperty(value = "标识名")
    private String tag;

    @ApiModelProperty(value = "名称")
    private String title;

    @ApiModelProperty(value = "列类型")
    private String type;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

}