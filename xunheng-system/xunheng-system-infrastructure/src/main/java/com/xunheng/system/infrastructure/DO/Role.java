package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_role")
@ApiModel(value = "角色")
@Table
public class Role extends BaseDO {

    private static final long serialVersionUID = 1L;

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

}
