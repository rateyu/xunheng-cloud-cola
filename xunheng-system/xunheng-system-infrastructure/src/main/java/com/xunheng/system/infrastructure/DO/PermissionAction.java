package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Index;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 菜单接口权限码
 * @author hhqkkr
 */
@Data
@TableName("sys_permission_action")
@Schema(description = "菜单接口权限码")
@Table
public class PermissionAction extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @Index
    @Schema(description = "菜单id")
    private  String permissionId;

    @Schema(description = "名称")
    private  String name;

    @Schema(description = "功能码")
    private  String code;

    @Schema(description = "是否启用 0启用 -1禁用")
    private Integer status;
}