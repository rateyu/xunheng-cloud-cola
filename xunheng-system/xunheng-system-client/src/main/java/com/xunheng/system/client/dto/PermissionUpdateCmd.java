package com.xunheng.system.client.dto;

import com.xunheng.base.vo.system.MetaVO;
import com.xunheng.base.vo.system.PermissionActionVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PermissionUpdateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @Schema(description = "父id")
    private String parentId;

    @NotBlank(message = "菜单/权限名称不能为空")
    @Schema(description = "菜单/权限名称")
    private String name;

    @Schema(description = "页面路径/资源链接url")
    private String path;

    @Schema(description = "前端组件")
    private String component;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;

    @Schema(description = "排序值")
    private BigDecimal sortOrder;

    @Schema(description = "菜单元数据")
    private MetaVO meta;

    @Schema(description = "操作功能集合")
    private List<PermissionActionVO> actionList;

}
