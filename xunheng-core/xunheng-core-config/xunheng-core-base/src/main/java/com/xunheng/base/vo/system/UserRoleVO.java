package com.xunheng.base.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;


/**
 * @program: xunheng-cloud-cola
 * @description: 用户与角色关联详情
 * @author: hhqkkr
 * @date: 2023/6/29 14:22
 */
@Data
public class UserRoleVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @Schema(description = "用户唯一id")
    private String userId;

    @Schema(description = "角色唯一id")
    private String roleId;

    @Schema(description = "角色名")
    private String roleName;

    @Schema(description = "角色描述")
    private String roleDescription;

    @Schema(description = "数据权限类型 0全部默认 1自定义")
    private Integer dataType ;
}
