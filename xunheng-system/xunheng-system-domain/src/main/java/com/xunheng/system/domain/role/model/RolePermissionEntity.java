package com.xunheng.system.domain.role.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RolePermissionEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "权限id")
    private String permissionId;

    @ApiModelProperty(value = "当前节点是否为半选中 0:halfCheck 1:allCheck")
    private Integer isAllCheck;

    public RolePermissionEntity() {
    }

    public RolePermissionEntity(String roleId, String permissionId, Integer isAllCheck) {
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.isAllCheck = isAllCheck;
    }
}
