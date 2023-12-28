package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("sys_dict_data")
@Schema(description = "字典数据")
@Table
public class DictData extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "数据名称")
    private String title;

    @Schema(description = "数据值")
    private String value;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "所属字典")
    private String dictId;

    @TableField(exist = false)
    @Schema(description = "所属字典信息")
    private Dict dictInfo;

}