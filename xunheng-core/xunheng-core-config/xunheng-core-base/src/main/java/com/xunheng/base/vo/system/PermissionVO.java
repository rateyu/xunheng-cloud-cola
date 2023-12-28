package com.xunheng.base.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 菜单/权限
 * @author hhqkkr
 */
@Data
public class PermissionVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @Schema(description = "菜单/权限名称")
    private String name;

    @Schema(description = "页面路径/资源链接url")
    private String path;

    @Schema(description = "前端组件")
    private String component;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "菜单元数据")
    private MetaVO meta;

    @Schema(description = "子菜单/权限")
    private List<PermissionVO> children;

    @Schema(description = "对应的功能code")
    private List<PermissionActionVO> actionList;

}