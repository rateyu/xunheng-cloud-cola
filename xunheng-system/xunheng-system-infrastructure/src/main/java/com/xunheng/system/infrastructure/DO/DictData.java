package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_dict_data")
@ApiModel(value = "字典数据")
@Table
public class DictData extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据名称")
    private String title;

    @ApiModelProperty(value = "数据值")
    private String value;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "所属字典")
    private String dictId;

    @TableField(exist = false)
    @ApiModelProperty(value = "所属字典信息")
    private Dict dictInfo;

}