package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 矩阵
 * @author hhqkkr
 * @date 2022-07-28 16:06:00
 */
@Data
@TableName("sys_matrix")
@Schema(description = "矩阵")
@Table
public class Matrix extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "描述")
    private String description;

}