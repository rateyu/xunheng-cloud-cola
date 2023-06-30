package com.xunheng.base.vo.system;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "菜单/权限名称")
    private String name;

    @ApiModelProperty(value = "页面路径/资源链接url")
    private String path;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "菜单元数据")
    private MetaVO meta;

    @ApiModelProperty(value = "子菜单/权限")
    private List<PermissionVO> children;

    @ApiModelProperty(value = "对应的功能code")
    private List<PermissionActionVO> actionList;

}