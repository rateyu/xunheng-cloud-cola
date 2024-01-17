package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgCreateCmd {

    @NotBlank(message = "appId不能为空")
    @Schema(description = "appId")
    private String appId;

    @NotBlank(message = "openId不能为空")
    @Schema(description = "openId")
    private String openId;

    @Schema(description = "消息方向")
    private Integer inOut;

    @Schema(description = "消息类型")
    private String msgType;

    @Schema(description = "消息详情")
    private String detail;

}
