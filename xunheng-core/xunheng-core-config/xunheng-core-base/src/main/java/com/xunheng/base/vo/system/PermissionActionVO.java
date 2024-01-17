package com.xunheng.base.vo.system;

import com.xunheng.base.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限与功能关联详情
 * @author: hhqkkr
 * @create: 2023-03-22 17:01
 */
@Data
public class PermissionActionVO {

    @Schema(description = "菜单id")
    private  String permissionId;

    @Schema(description = "名称")
    private  String name;

    @Schema(description = "功能码")
    private  String code;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;
}
