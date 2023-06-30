package com.xunheng.system.domain.organization.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.base.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class OrganizationEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "部门名称")
    private String title;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "分公司id")
    private String subCompanyId;

}
