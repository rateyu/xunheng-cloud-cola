package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 菜单/权限
 * @author hhqkkr
 */
@Data
@TableName("sys_permission")
@Schema(description = "菜单权限")
@Table
public class Permission extends BaseDO {

    private static final long serialVersionUID = 1L;

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

}