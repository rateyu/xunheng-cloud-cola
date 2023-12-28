package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserSystemUpdateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @NotBlank(message = "用户名不能为空")
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

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Schema(description = "生日")
    private Date birth;

    @Schema(description = "个性签名")
    private String about;

    @Schema(description = "用户头像")
    private String avatar;

    @NotNull(message = "用户级别不能为空")
    @Schema(description = "用户级别 -1 体验用户 0普通用户 1.分公司管理员 2.租户管理员 3.超级管理员")
    private Integer type;

    @Schema(description = "状态 默认0正常 -1拉黑")
    private Integer status;

    @Schema(description = "描述/详情/备注")
    private String description;

    @NotNull(message = "租户不能为空")
    @Schema(description = "租户")
    private TenantObj tenantObj;

    @Schema(description = "直接上级")
    private SuperiorObj superiorObj;

    @NotEmpty(message = "所属组织不能为空")
    @Schema(description = "所属组织id")
    private String[] organizationId;

    @Schema(description = "角色集合")
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
