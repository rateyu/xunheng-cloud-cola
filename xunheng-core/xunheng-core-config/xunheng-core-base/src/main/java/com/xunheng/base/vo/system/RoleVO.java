package com.xunheng.base.vo.system;

import com.xunheng.base.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色vo
 * @author: hhqkkr
 * @date: 2023/6/29 14:22
 */
@Data
public class RoleVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "角色名 以ROLE_开头")
    private String name;

    @ApiModelProperty(value = "数据权限类型 CommonConstant.DATA_TYPE_*")
    private Integer dataType = CommonConstant.DATA_TYPE_LEVEL;

    @ApiModelProperty(value = "数据权限级别 CommonConstant.DATA_LEVEL_*")
    private Integer dataLevel = CommonConstant.DATA_LEVEL_NONE;

    @ApiModelProperty(value = "自定义表达式")
    private String customExpression;

    @ApiModelProperty(value = "是否含下级 0:否 1:是")
    private Integer includeLow = -1;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "拥有数据权限范围ids")
    private String organizationIds;

    @ApiModelProperty(value = "拥有菜单权限")
    private List<RolePermissionVO> permissions;

}
