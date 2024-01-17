package com.xunheng.base.vo.system;

import com.xunheng.base.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "角色名 以ROLE_开头")
    private String name;

    @Schema(description = "数据权限类型 CommonConstant.DATA_TYPE_*")
    private Integer dataType = CommonConstant.DATA_TYPE_LEVEL;

    @Schema(description = "数据权限级别 CommonConstant.DATA_LEVEL_*")
    private Integer dataLevel = CommonConstant.DATA_LEVEL_NONE;

    @Schema(description = "自定义表达式")
    private String customExpression;

    @Schema(description = "是否含下级 0:否 1:是")
    private Integer includeLow = -1;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "拥有数据权限范围ids")
    private String organizationIds;

    @Schema(description = "拥有菜单权限")
    private List<RolePermissionVO> permissions;

}
