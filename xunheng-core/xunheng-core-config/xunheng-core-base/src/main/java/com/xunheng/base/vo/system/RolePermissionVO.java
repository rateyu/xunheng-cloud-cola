package com.xunheng.base.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色与权限关联详情
 * @author: hhqkkr
 * @date: 2023/6/29 14:21
 */
@Data
public class RolePermissionVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "角色id")
    private String roleId;

    @Schema(description = "权限id")
    private String permissionId;

    @Schema(description = "当前节点是否为半选中 0:halfCheck 1:allCheck")
    private Integer isAllCheck;
}
