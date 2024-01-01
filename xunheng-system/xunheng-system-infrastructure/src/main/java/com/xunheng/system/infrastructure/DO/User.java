package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.ColumnType;
import com.tangzc.mpe.autotable.annotation.Table;
import com.tangzc.mpe.autotable.strategy.mysql.data.MysqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_user")
@Schema(description = "用户")
@Table
public class User extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "手机")
    private String mobile;

    @Schema(description = "邮件")
    private String email;

    @Schema(description = "省市县地址")
    private String address;

    @Schema(description = "街道地址")
    private String street;

    @Schema(description = "性别")
    private String sex;

    @ColumnType(MysqlTypeConstant.DATE)
    @Schema(description = "生日")
    private Date birth;

    @Schema(description = "个性签名")
    private String about;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "直接上级")
    private String superior;

    @Schema(description = "用户级别 -1 体验用户 0普通用户 1.分公司管理员 2.租户管理员 3.超级管理员")
    private Integer type;

    @Schema(description = "状态 默认0正常 -1拉黑")
    private Integer status;

    @Schema(description = "描述/详情/备注")
    private String description;

    @Schema(description = "所属组织id")
    private String organizationId;

    @Schema(description = "租户id")
    private String tenantId;

    @TableField(exist = false)
    @Schema(description = "租户名称")
    private String tenantTitle;

    @TableField(exist = false)
    @Schema(description = "分公司名称")
    private String subCompanyTitle;

    @TableField(exist = false)
    @Schema(description = "部门名称")
    private String departmentTitle;

    @TableField(exist = false)
    @Schema(description = "直接上级用户名")
    private String superiorUsername;

}
