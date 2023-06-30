package com.xunheng.system.client.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.xunheng.base.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class OrganizationCreateCmd {

    @NotBlank(message = "部门名称不能为空")
    @ApiModelProperty(value = "部门名称")
    private String title;


    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstant.STATUS_NORMAL;

    @NotBlank(message = "类型不能为空")
    @ApiModelProperty(value = "类型")
    private String type ;


    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "分公司id")
    private String subCompanyId;

}
