package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgTemplateCreateCmd {

    @NotBlank(message = "appId不能为空")
    @Schema(description = "appId")
    private String appId;

    @NotBlank(message = "模板Id不能为空")
    @Schema(description = "模板Id")
    private String templateId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "数据")
    private String data;

    @Schema(description = "链接地址")
    private String url;

    @Schema(description = "小程序")
    private String miniProgram;

    @Schema(description = "状态")
    private String status;

}
