package com.xunheng.system.domain.user.model;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
public class UserRoleEntity {

    @Schema(description = "id")
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
