package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WechatAccountCreateCmd {

    @NotBlank(message = "appId不能为空")
    @Schema(description = "appId")
    private String appId;

    @NotBlank(message = "名称不能为空")
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
