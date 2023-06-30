package com.xunheng.base.vo.system;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "权限id")
    private String permissionId;

    @ApiModelProperty(value = "当前节点是否为半选中 0:halfCheck 1:allCheck")
    private Integer isAllCheck;
}
