package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author hhqkkr
 */
@Data
@TableName("sys_role_permission")
@ApiModel(value = "角色权限")
@Table
public class RolePermission extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "权限id")
    private String permissionId;

    @ApiModelProperty(value = "当前节点是否为半选中 0:halfCheck 1:allCheck")
    private Integer isAllCheck;
}