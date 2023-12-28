package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


/**
 * @author hhqkkr
 */
@Data
@TableName("sys_user_role")
@Schema(description = "用户角色")
@Table
public class UserRole extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户唯一id")
    private String userId;

    @Schema(description = "角色唯一id")
    private String roleId;

    @TableField(exist = false)
    @Schema(description = "角色名")
    private String roleName;

    @TableField(exist = false)
    @Schema(description = "角色描述")
    private String roleDescription;

    @TableField(exist = false)
    @Schema(description = "数据权限类型 0全部默认 1自定义")
    private Integer dataType ;

}
