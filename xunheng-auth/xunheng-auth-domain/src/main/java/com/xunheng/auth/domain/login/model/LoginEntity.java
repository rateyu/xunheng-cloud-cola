package com.xunheng.auth.domain.login.model;

import com.alibaba.cola.domain.Entity;
import com.alibaba.nacos.common.utils.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.poi.util.StringUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: xunheng-cloud-cola
 * @description: login领域
 * @author: hhqkkr
 * @create: 2023-06-12 23:38
 */
@Data
@Entity
public class LoginEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "验证码")
    private CaptchaEntity captcha;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "保存登录状态")
    private String saveLogin;

    @ApiModelProperty(value = "登录设备")
    private String device;

    /**
     * 校验密码
     * @param rpassword 未加密密码
     * @return
     */
    public Boolean checkPassword(String rpassword){
        if(StringUtils.isEmpty(rpassword))return false;
        BCryptPasswordEncoder encode=new BCryptPasswordEncoder();
        if(!encode.matches(password,rpassword)){
          return false;
        }
        return true;
    }

}
