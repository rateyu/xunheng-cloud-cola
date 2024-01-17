package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgFeedRecordCreateCmd {

    @NotBlank(message = "appId不能为空")
    @Schema(description = "appId")
    private String appId;

    @NotBlank(message = "对象openId不能为空")
    @Schema(description = "对象openId")
    private String openId;

    @NotBlank(message = "模板id不能为空")
    @Schema(description = "模板id")
    private String templateId;

    @Schema(description = "数据")
    private String data;

    @Schema(description = "链接地址")
    private String url;

    @Schema(description = "小程序")
    private String miniProgram;

    @Schema(description = "推送结果")
    private String feedResult;

}
