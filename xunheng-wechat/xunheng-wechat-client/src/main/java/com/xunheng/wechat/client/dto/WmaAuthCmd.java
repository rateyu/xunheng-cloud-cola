package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WmaAuthCmd {

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "code")
    private String code;
}
