package com.xunheng.auth.domain.login.model;

import lombok.Data;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Data
public class CaptchaImg {

    private String src;

    /**
     * 根据验证码生成bsse64图像
     * @param verifyCode 验证码实体
     */
    public CaptchaImg(VerifyCode verifyCode){
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(verifyCode.getBuffImg(), "png", stream);
            this.src = Base64.getEncoder().encodeToString(stream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
