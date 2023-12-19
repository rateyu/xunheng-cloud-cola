package com.xunheng.wechat.domain.account.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

@Data
@Entity
public class WechatAccountEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "appSecret")
    private String appSecret;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "aesKey")
    private String aesKey;

    @ApiModelProperty(value = "类型")
    private AccountType type;

    public WxMpDefaultConfigImpl toWxMpConfigStorage(){
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(appId);
        configStorage.setSecret(appSecret);
        configStorage.setToken(token);
        configStorage.setAesKey(aesKey);
        return configStorage;
    }
}
