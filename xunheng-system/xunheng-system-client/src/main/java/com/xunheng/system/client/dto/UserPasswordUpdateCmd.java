package com.xunheng.system.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UserPasswordUpdateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @NotBlank(message = "原密码不能为空")
    @ApiModelProperty(value = "原密码")
    private String password;

    @NotBlank(message = "新密码不能为空")
    @ApiModelProperty(value = "新密码")
    private String newPass;


}
