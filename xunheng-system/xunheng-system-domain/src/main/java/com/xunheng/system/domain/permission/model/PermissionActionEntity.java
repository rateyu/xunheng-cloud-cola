package com.xunheng.system.domain.permission.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class PermissionActionEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "菜单id")
    private  String permissionId;

    @ApiModelProperty(value = "名称")
    private  String name;

    @ApiModelProperty(value = "功能码")
    private  String code;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;
}