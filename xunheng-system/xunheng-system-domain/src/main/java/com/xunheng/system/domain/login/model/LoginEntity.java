package com.xunheng.system.domain.login.model;

import com.alibaba.cola.domain.Entity;
import com.alibaba.nacos.common.utils.StringUtils;
import lombok.Data;
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

    private String id;

    private String username;

    private String password;

    private CaptchaEntity captcha;

    private String ip;

    private String saveLogin;

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
