package com.xunheng.system.client.dto;

import com.xunheng.base.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class OrganizationUpdateCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @NotBlank(message = "部门名称不能为空")
    @ApiModelProperty(value = "部门名称")
    private String title;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @NotBlank(message = "类型")
    @ApiModelProperty(value = "类型")
    private String type ;

    @ApiModelProperty(value = "分公司id")
    private String subCompanyId;

}
