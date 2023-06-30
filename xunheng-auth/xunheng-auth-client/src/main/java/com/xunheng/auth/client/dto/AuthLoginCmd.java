package com.xunheng.auth.client.dto;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.constant.SaSessionConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthLoginCmd {

    @NotBlank(message="用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank(message="密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @NotBlank(message="验证码不能为空")
    @ApiModelProperty(value = "验证码")
    private String code;

    @NotBlank(message="验证码id不能为空")
    @ApiModelProperty(value = "验证码id")
    private String captchaId;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "保存登录状态")
    private String saveLogin;

    @ApiModelProperty(value = "登录设备")
    private String device = SaSessionConstant.LOGIN_DEVICE_PC;
}
