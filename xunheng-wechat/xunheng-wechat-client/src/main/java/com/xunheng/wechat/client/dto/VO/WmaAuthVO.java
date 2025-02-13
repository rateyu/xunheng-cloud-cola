package com.xunheng.wechat.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WmaAuthVO {


    @Schema(description = "appId")
    private String appId;

    @Schema(description = "openId")
    private String openId;

    @Schema(description = "token")
    private String token;

    @Schema(description = "头像")
    private String headImgUrl;

    @Schema(description = "用户名")
    private String nickName;

}
