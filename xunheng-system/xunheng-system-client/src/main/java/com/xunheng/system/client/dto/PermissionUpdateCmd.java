package com.xunheng.system.client.dto;

import com.xunheng.base.vo.system.MetaVO;
import com.xunheng.base.vo.system.PermissionActionVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PermissionUpdateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @NotBlank(message = "菜单/权限名称不能为空")
    @ApiModelProperty(value = "菜单/权限名称")
    private String name;

    @ApiModelProperty(value = "页面路径/资源链接url")
    private String path;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "菜单元数据")
    private MetaVO meta;

    @ApiModelProperty(value = "操作功能集合")
    private List<PermissionActionVO> actionList;

}
