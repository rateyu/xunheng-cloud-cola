package com.xunheng.system.domain.user.model;

import com.alibaba.cola.domain.Entity;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.system.domain.customConfig.model.CustomConfigEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class UserEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "加入时间")
    private Date createTime;

    @ApiModelProperty(value = "数据部门id")
    private String departmentId;

    @ApiModelProperty(value = "分公司id")
    private String subCompanyId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private PassWord password;

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

    @ApiModelProperty(value = "租户名称")
    private String tenantTitle;

    @ApiModelProperty(value = "分公司名称")
    private String subCompanyTitle;

    @ApiModelProperty(value = "部门名称")
    private String departmentTitle;

    @ApiModelProperty(value = "直接上级用户名")
    private String superiorUsername;

    @ApiModelProperty(value = "角色集合")
    private List<UserRoleEntity> roles;

    @ApiModelProperty(value = "角色id集合")
    private List<String> roleIds;

    @ApiModelProperty(value = "个性化设置")
    private List<CustomConfigEntity> personalConfigs;

    @ApiModelProperty(value = "下级员工ids(包括自己)")
    private String  userLowIds;

    @ApiModelProperty(value = "下级部门ids(包括自己)")
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
