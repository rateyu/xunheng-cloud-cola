package com.xunheng.system.domain.user.model;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class UserRoleEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户唯一id")
    private String userId;

    @ApiModelProperty(value = "角色唯一id")
    private String roleId;

    @ApiModelProperty(value = "角色名")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String roleDescription;

    @ApiModelProperty(value = "数据权限类型 0全部默认 1自定义")
    private Integer dataType ;
}
