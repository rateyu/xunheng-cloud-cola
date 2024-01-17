package com.xunheng.system.client.dto;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.vo.system.MetaVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class PermissionCreateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "菜单/权限名称")
    @Schema(description = "菜单/权限名称")
    private String name;

    @Schema(description = "父id")
    private String parentId;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstant.STATUS_NORMAL;

    @Schema(description = "页面路径/资源链接url")
    private String path;

    @Schema(description = "前端组件")
    private String component;

    @Schema(description = "菜单元数据")
    private MetaVO meta;

}
