package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WechatQrCodeUpdateCmd {

    @Schema(description = "id")
    private String id;

    @NotBlank(message = "appId不能为空")
    @Schema(description = "appId")
    private String appId;

    @NotBlank(message = "二维码类型不能为空")
    @Schema(description = "二维码类型")
    private String type;

    @Schema(description = "场景值id")
    private Integer sceneStr;

    @Schema(description = "二维码ticket")
    private String ticket;

    @Schema(description = "地址")
    private String url;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "过期时间")
    private Date expireTime;

}
