package com.xunheng.system.client.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.xunheng.base.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class OrganizationCreateCmd {

    @NotBlank(message = "部门名称不能为空")
    @Schema(description = "部门名称")
    private String title;


    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstant.STATUS_NORMAL;

    @NotBlank(message = "类型不能为空")
    @Schema(description = "类型")
    private String type ;


    @Schema(description = "租户id")
    private String tenantId;

    @Schema(description = "分公司id")
    private String subCompanyId;

}
