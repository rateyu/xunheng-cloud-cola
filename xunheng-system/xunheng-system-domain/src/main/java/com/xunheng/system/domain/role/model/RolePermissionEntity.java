package com.xunheng.system.domain.role.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RolePermissionEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "角色id")
    private String roleId;

    @Schema(description = "权限id")
    private String permissionId;

    @Schema(description = "当前节点是否为半选中 0:halfCheck 1:allCheck")
    private Integer isAllCheck;

    public RolePermissionEntity() {
    }

    public RolePermissionEntity(String roleId, String permissionId, Integer isAllCheck) {
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.isAllCheck = isAllCheck;
    }
}
