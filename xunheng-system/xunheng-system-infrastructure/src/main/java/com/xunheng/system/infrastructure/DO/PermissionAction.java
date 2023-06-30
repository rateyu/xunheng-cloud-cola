package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Index;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 菜单接口权限码
 * @author hhqkkr
 */
@Data
@TableName("sys_permission_action")
@ApiModel(value = "菜单接口权限码")
@Table
public class PermissionAction extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @Index
    @ApiModelProperty(value = "菜单id")
    private  String permissionId;

    @ApiModelProperty(value = "名称")
    private  String name;

    @ApiModelProperty(value = "功能码")
    private  String code;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status;
}