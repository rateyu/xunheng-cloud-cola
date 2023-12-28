package com.xunheng.system.domain.user.model;

import com.alibaba.cola.domain.Entity;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.system.domain.customConfig.model.CustomConfigEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class UserEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "加入时间")
    private Date createTime;

    @Schema(description = "数据部门id")
    private String departmentId;

    @Schema(description = "分公司id")
    private String subCompanyId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private PassWord password;

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

    @ColumnType(MySqlTypeConstant.DATE)
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

    @Schema(description = "租户名称")
    private String tenantTitle;

    @Schema(description = "分公司名称")
    private String subCompanyTitle;

    @Schema(description = "部门名称")
    private String departmentTitle;

    @Schema(description = "直接上级用户名")
    private String superiorUsername;

    @Schema(description = "角色集合")
    private List<UserRoleEntity> roles;

    @Schema(description = "角色id集合")
    private List<String> roleIds;

    @Schema(description = "个性化设置")
    private List<CustomConfigEntity> personalConfigs;

    @Schema(description = "下级员工ids(包括自己)")
    private String  userLowIds;

    @Schema(description = "下级部门ids(包括自己)")
    private String  departmentLowIds;


    public void bindRoleInfo(List<UserRoleEntity> roleList){
        this.setRoles(roleList);
        List<String> roleIds = new ArrayList<>();
        for (UserRoleEntity userRole : roleList) {
            String roleId = userRole.getRoleId();
            roleIds.add(roleId);
        }
        this.setRoleIds(roleIds);
    }



}
