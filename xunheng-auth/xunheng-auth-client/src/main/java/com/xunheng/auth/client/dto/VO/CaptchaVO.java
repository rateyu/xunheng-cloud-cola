package com.xunheng.auth.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CaptchaVO {

    @ApiModelProperty(value = "验证码id")
    private String captchaId;

    @ApiModelProperty(value = "图片base64编码")
    private String base64Src;
}
