package com.xunheng.wechat.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WechatAccountVO {

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
    private Integer type;

}
