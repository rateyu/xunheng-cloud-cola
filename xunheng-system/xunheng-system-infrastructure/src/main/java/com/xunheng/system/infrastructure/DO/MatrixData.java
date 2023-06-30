package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 矩阵数据
 * @author hhqkkr
 * @date 2022-07-28 16:09:01
 */
@Data
@TableName("sys_matrix_data")
@ApiModel(value = "矩阵数据")
@Table
public class MatrixData extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "矩阵id")
    private String matrixId;

    @ApiModelProperty(value = "矩阵列标识")
    private String columnTag;

    @ApiModelProperty(value = "矩阵行id")
    private String rowId;

    @ApiModelProperty(value = "矩阵数据")
    private String data;

}