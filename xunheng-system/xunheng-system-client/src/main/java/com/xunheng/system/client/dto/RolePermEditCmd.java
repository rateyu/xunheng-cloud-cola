package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RolePermEditCmd {

    @Schema(description = "角色id")
    private String roleId;

    @Schema(description = "数据权限类型")
    private Integer dataType;

    @Schema(description = "数据级别")
    private Integer dataLevel;

    @Schema(description = "是否包含下级")
    private Integer includeLow;

    @Schema(description = "菜单未全选集合")
    private String[] menuHalfCheckIds;

    @Schema(description = "菜单全选集合")
    private String[] menuAllCheckIds;

}
