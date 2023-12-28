package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


/**
 * @author hhqkkr
 */
@Data
@TableName("sys_role_permission")
@Schema(description = "角色权限")
@Table
public class RolePermission extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "角色id")
    private String roleId;

    @Schema(description = "权限id")
    private String permissionId;

    @Schema(description = "当前节点是否为半选中 0:halfCheck 1:allCheck")
    private Integer isAllCheck;
}