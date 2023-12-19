package com.xunheng.wechat.client.dto;

import lombok.Data;

@Data
public class WoaAuthCheckCmd {

    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

}
