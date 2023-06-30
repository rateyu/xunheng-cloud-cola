package com.xunheng.system.domain.permission.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class PermissionEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "菜单/权限名称")
    private String name;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "页面路径/资源链接url")
    private String path;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "整页路由")
    private Boolean fullpage;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "对应的功能code")
    private List<PermissionActionEntity> actionList;

}