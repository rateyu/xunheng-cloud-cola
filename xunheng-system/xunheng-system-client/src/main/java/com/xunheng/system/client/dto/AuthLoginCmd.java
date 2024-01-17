package com.xunheng.system.client.dto;

import com.xunheng.base.constant.SaSessionConstant;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class AuthLoginCmd {

    @NotBlank(message="用户名不能为空")
    private String username;

    @NotBlank(message="密码不能为空")
    private String password;

    @NotBlank(message="验证码不能为空")
    private String code;

    @NotBlank(message="验证码id不能为空")
    private String captchaId;

    private String ip;

    private String saveLogin;

    private String device = SaSessionConstant.LOGIN_DEVICE_PC;
}
