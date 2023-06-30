package com.xunheng.system.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserSystemUpdateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @NotBlank(message = "用户名不能为空")
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

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
    private Date birth;

    @ApiModelProperty(value = "个性签名")
    private String about;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @NotNull(message = "用户级别不能为空")
    @ApiModelProperty(value = "用户级别 -1 体验用户 0普通用户 1.分公司管理员 2.租户管理员 3.超级管理员")
    private Integer type;

    @ApiModelProperty(value = "状态 默认0正常 -1拉黑")
    private Integer status;

    @ApiModelProperty(value = "描述/详情/备注")
    private String description;

    @NotNull(message = "租户不能为空")
    @ApiModelProperty(value = "租户")
    private TenantObj tenantObj;

    @ApiModelProperty(value = "直接上级")
    private SuperiorObj superiorObj;

    @NotEmpty(message = "所属组织不能为空")
    @ApiModelProperty(value = "所属组织id")
    private String[] organizationId;

    @ApiModelProperty(value = "角色集合")
    private String[] roleIds;

    @Data
    public static class TenantObj{
        String id;
        String name;
    }

    @Data
    public static class SuperiorObj{
        String id;
        String name;
    }

}
