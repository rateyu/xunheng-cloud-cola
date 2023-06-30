package com.xunheng.system.client.dto;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.vo.system.MetaVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class PermissionCreateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "菜单/权限名称")
    @ApiModelProperty(value = "菜单/权限名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstant.STATUS_NORMAL;

    @ApiModelProperty(value = "页面路径/资源链接url")
    private String path;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "菜单元数据")
    private MetaVO meta;

}
