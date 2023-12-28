package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_dict")
@Schema(description = "字典")
@Table
public class Dict extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "字典名称")
    private String title;

    @Schema(description = "字典类型")
    private String type;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;
}