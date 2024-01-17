package com.xunheng.wechat.domain.account.model;

import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

@Data
@Entity
public class WechatAccountEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "appSecret")
    private String appSecret;

    @Schema(description = "token")
    private String token;

    @Schema(description = "aesKey")
    private String aesKey;

    @Schema(description = "类型")
    private AccountType type;

    public WxMpDefaultConfigImpl toWxMpConfigStorage(){
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(appId);
        configStorage.setSecret(appSecret);
        configStorage.setToken(token);
        configStorage.setAesKey(aesKey);
        return configStorage;
    }

    public WxMaDefaultConfigImpl toWxMaConfigStorage(){
        WxMaDefaultConfigImpl configStorage = new WxMaDefaultConfigImpl();
        configStorage.setAppid(appId);
        configStorage.setSecret(appSecret);
        configStorage.setToken(token);
        configStorage.setAesKey(aesKey);
        return configStorage;
    }
}
