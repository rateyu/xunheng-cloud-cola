package com.xunheng.wechat.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WmaAuthVO {


    @Schema(description = "appId")
    private String appId;

    @Schema(description = "openId")
    private String openId;

}
