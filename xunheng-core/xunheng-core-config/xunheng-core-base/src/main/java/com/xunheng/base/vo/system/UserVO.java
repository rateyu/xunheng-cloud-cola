package com.xunheng.base.vo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户详情vo
 * @author: hhqkkr
 * @date: 2023/6/29 14:22
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "加入时间")
    private Date createTime;

    @ApiModelProperty(value = "用户名")
    private String username;

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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
    private Date birth;

    @ApiModelProperty(value = "个性签名")
    private String about;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户级别 0普通用户 1.分公司管理员 2.租户管理员 3.超级管理员")
    private Integer type;

    @ApiModelProperty(value = "状态 默认0正常 -1拉黑")
    private Integer status;

    @ApiModelProperty(value = "描述/详情/备注")
    private String description;

    @ApiModelProperty(value = "所属组织id")
    private String organizationId;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "分公司id")
    private String subCompanyId;

    @ApiModelProperty(value = "直接上级")
    private String superior;

    @ApiModelProperty(value = "租户名称")
    private String tenantTitle;

    @ApiModelProperty(value = "分公司名称")
    private String subCompanyTitle;

    @ApiModelProperty(value = "部门名称")
    private String departmentTitle;

    @ApiModelProperty(value = "直接上级用户名")
    private String superiorUsername;

    @ApiModelProperty(value = "角色集合")
    private List<UserRoleVO> roles;

    @ApiModelProperty(value = "角色id集合")
    private List<String> roleIds;

    @ApiModelProperty(value = "权限集合")
    private List<PermissionVO> permissions;

    @ApiModelProperty(value = "权限码集合")
    private List<String> permissionCodes;

    @ApiModelProperty(value = "个性化设置")
    private List<PersonalConfigVO> personalConfigs;

    @ApiModelProperty(value = "下级员工ids(包括自己)")
    private String  userLowIds;

    @ApiModelProperty(value = "下级部门ids(包括自己)")
    private String  departmentLowIds;
}
