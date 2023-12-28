package com.xunheng.system.domain.permission.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class PermissionActionEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "菜单id")
    private  String permissionId;

    @Schema(description = "名称")
    private  String name;

    @Schema(description = "功能码")
    private  String code;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;
}