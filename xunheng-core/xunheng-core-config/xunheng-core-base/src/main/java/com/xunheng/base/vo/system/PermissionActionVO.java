package com.xunheng.base.vo.system;

import com.xunheng.base.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限与功能关联详情
 * @author: hhqkkr
 * @create: 2023-03-22 17:01
 */
@Data
public class PermissionActionVO {

    @ApiModelProperty(value = "菜单id")
    private  String permissionId;

    @ApiModelProperty(value = "名称")
    private  String name;

    @ApiModelProperty(value = "功能码")
    private  String code;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;
}
