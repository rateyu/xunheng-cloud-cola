package com.xunheng.system.infrastructure.DO;

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
@TableName("sys_organization")
@ApiModel(value = "组织架构")
@Table
public class Organization extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门名称")
    private String title;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "类型")
    private String type ;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "分公司id")
    private String subCompanyId;

}