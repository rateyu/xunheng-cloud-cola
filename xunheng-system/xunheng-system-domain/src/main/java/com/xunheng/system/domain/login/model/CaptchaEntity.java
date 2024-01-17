package com.xunheng.system.domain.login.model;

import cn.hutool.core.util.StrUtil;
import com.xunheng.base.exception.CaptchaErrorException;
import lombok.Data;

import java.util.UUID;

@Data
public class CaptchaEntity {

    private String captchaId;

    private VerifyCode verifyCode;

    private CaptchaImg captchaImg;

    /**
     * 验证码构造器 创建验证码信息
     */
    public CaptchaEntity(){
        this.captchaId = UUID.randomUUID().toString().replace("-","");
        this.verifyCode = new VerifyCode();;
        this.captchaImg = new CaptchaImg(this.verifyCode);
    }

    public CaptchaEntity(String captchaId,String code){
        if(StrUtil.isBlank(captchaId)||StrUtil.isBlank(code))throw new CaptchaErrorException("请传入图形验证码所需参数captchaId或code");
        this.captchaId = captchaId;
        this.verifyCode = new VerifyCode(code);
    }
}

