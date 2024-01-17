package com.xunheng.system.app.assembler;


import com.xunheng.system.client.dto.AuthLoginCmd;
import com.xunheng.system.domain.login.model.CaptchaEntity;
import com.xunheng.system.domain.login.model.LoginEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 登录DTO转换
 * @author: hhqkkr
 * @date: 2023/6/29 12:43
 */
public class LoginAssembler {

    public static LoginEntity toEntity(AuthLoginCmd cmd) {
        LoginEntity entity = new LoginEntity();
        entity.setUsername(cmd.getUsername());
        entity.setPassword(cmd.getPassword());
        entity.setCaptcha(new CaptchaEntity(cmd.getCaptchaId(),cmd.getCode()));
        entity.setIp(cmd.getIp());
        entity.setSaveLogin(cmd.getSaveLogin());
        entity.setDevice(cmd.getDevice());
        return entity;
    }

}
