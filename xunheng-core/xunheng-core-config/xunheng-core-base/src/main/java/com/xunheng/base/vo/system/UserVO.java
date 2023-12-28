package com.xunheng.base.vo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "加入时间")
    private Date createTime;

    @Schema(description = "用户名")
    private String username;

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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "生日")
    private Date birth;

    @Schema(description = "个性签名")
    private String about;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "用户级别 0普通用户 1.分公司管理员 2.租户管理员 3.超级管理员")
    private Integer type;

    @Schema(description = "状态 默认0正常 -1拉黑")
    private Integer status;

    @Schema(description = "描述/详情/备注")
    private String description;

    @Schema(description = "所属组织id")
    private String organizationId;

    @Schema(description = "租户id")
    private String tenantId;

    @Schema(description = "分公司id")
    private String subCompanyId;

    @Schema(description = "直接上级")
    private String superior;

    @Schema(description = "租户名称")
    private String tenantTitle;

    @Schema(description = "分公司名称")
    private String subCompanyTitle;

    @Schema(description = "部门名称")
    private String departmentTitle;

    @Schema(description = "直接上级用户名")
    private String superiorUsername;

    @Schema(description = "角色集合")
    private List<UserRoleVO> roles;

    @Schema(description = "角色id集合")
    private List<String> roleIds;

    @Schema(description = "权限集合")
    private List<PermissionVO> permissions;

    @Schema(description = "权限码集合")
    private List<String> permissionCodes;

    @Schema(description = "个性化设置")
    private List<PersonalConfigVO> personalConfigs;

    @Schema(description = "下级员工ids(包括自己)")
    private String  userLowIds;

    @Schema(description = "下级部门ids(包括自己)")
    private String  departmentLowIds;
}
