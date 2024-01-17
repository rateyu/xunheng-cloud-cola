package com.xunheng.system.client.dto;

import com.xunheng.base.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class OrganizationUpdateCmd {

    @Schema(description = "id")
    private String id;

    @NotBlank(message = "部门名称不能为空")
    @Schema(description = "部门名称")
    private String title;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @NotBlank(message = "类型")
    @Schema(description = "类型")
    private String type ;

    @Schema(description = "分公司id")
    private String subCompanyId;

}
