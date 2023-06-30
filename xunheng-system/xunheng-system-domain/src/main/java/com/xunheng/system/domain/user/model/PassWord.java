package com.xunheng.system.domain.user.model;

import com.alibaba.nacos.common.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
public class PassWord {

    private EncryptionPassWord encryptionPassWord;

    public PassWord(EncryptionPassWord encryptionPassWord) {
        this.encryptionPassWord = encryptionPassWord;
    }

    public PassWord(String password) {
        this.encryptionPassWord = new EncryptionPassWord(getEncryptionPassWord(password));
    }

    public static String getEncryptionPassWord(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    @Getter
    public static class EncryptionPassWord {

        private String password;

        public EncryptionPassWord(String password) {
            this.password = password;
        }
    }

    /**
     * 判断密码相等
     * @param password
     * @return
     */
    public Boolean isEqual(String password) {
        if(StringUtils.isEmpty(password))return false;
        BCryptPasswordEncoder encode=new BCryptPasswordEncoder();
        if(!encode.matches(password,this.encryptionPassWord.password)){
            return false;
        }
        return true;


    }
}
