package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UserPasswordUpdateCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @NotBlank(message = "原密码不能为空")
    @Schema(description = "原密码")
    private String password;

    @NotBlank(message = "新密码不能为空")
    @Schema(description = "新密码")
    private String newPass;


}
