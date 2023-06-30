package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_user")
@ApiModel(value = "用户")
@Table
public class User extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "省市县地址")
    private String address;

    @ApiModelProperty(value = "街道地址")
    private String street;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ColumnType(MySqlTypeConstant.DATE)
    @ApiModelProperty(value = "生日")
    private Date birth;

    @ApiModelProperty(value = "个性签名")
    private String about;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "直接上级")
    private String superior;

    @ApiModelProperty(value = "用户级别 -1 体验用户 0普通用户 1.分公司管理员 2.租户管理员 3.超级管理员")
    private Integer type;

    @ApiModelProperty(value = "状态 默认0正常 -1拉黑")
    private Integer status;

    @ApiModelProperty(value = "描述/详情/备注")
    private String description;

    @ApiModelProperty(value = "所属组织id")
    private String organizationId;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @TableField(exist = false)
    @ApiModelProperty(value = "租户名称")
    private String tenantTitle;

    @TableField(exist = false)
    @ApiModelProperty(value = "分公司名称")
    private String subCompanyTitle;

    @TableField(exist = false)
    @ApiModelProperty(value = "部门名称")
    private String departmentTitle;

    @TableField(exist = false)
    @ApiModelProperty(value = "直接上级用户名")
    private String superiorUsername;

}
