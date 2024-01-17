package com.xunheng.system.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrganizationVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "部门名称")
    private String title;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "租户id")
    private String tenantId;

    @Schema(description = "分公司id")
    private String subCompanyId;

    @Schema(description = "父节点名称")
    private String parentTitle;

    @Schema(description = "下级组织")
    private List<OrganizationVO> children;

}
