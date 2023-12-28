package com.xunheng.wechat.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WechatQrCodeVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "二维码类型")
    private String type;

    @Schema(description = "场景值id")
    private Integer sceneStr;

    @Schema(description = "二维码ticket")
    private String ticket;

    @Schema(description = "地址")
    private String url;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "过期时间")
    private Date expireTime;

}
