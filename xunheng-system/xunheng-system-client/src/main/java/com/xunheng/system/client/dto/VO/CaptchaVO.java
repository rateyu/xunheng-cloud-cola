package com.xunheng.system.client.dto.VO;

import lombok.Data;

@Data
public class CaptchaVO {

    private String captchaId;

    private String base64Src;
}
