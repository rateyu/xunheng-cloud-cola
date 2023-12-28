package com.xunheng.system.domain.permission.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class PermissionEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "菜单/权限名称")
    private String name;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "菜单标题")
    private String title;

    @Schema(description = "页面路径/资源链接url")
    private String path;

    @Schema(description = "前端组件")
    private String component;

    @Schema(description = "图标")
    private String icon;

    @Schema(description = "整页路由")
    private Boolean fullpage;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "对应的功能code")
    private List<PermissionActionEntity> actionList;

}