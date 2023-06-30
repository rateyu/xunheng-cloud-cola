package com.xunheng.system.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RolePermEditCmd {

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "数据权限类型")
    private Integer dataType;

    @ApiModelProperty(value = "数据级别")
    private Integer dataLevel;

    @ApiModelProperty(value = "是否包含下级")
    private Integer includeLow;

    @ApiModelProperty(value = "菜单未全选集合")
    private String[] menuHalfCheckIds;

    @ApiModelProperty(value = "菜单全选集合")
    private String[] menuAllCheckIds;

}
