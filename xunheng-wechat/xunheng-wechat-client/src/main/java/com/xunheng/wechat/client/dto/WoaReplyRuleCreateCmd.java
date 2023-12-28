package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaReplyRuleCreateCmd {

    @Schema(description = "appId")
    private String appId;

    @NotBlank(message = "规则名称不能为空")
    @Schema(description = "规则名称")
    private String ruleName;

    @NotBlank(message = "匹配关键词不能为空")
    @Schema(description = "匹配关键词")
    private String matchValue;

    @Schema(description = "精准匹配")
    private Integer exactMatch;

    @Schema(description = "回复类型")
    private String replyType;

    @NotBlank(message = "回复内容不能为空")
    @Schema(description = "回复内容")
    private String replyContent;

    @Schema(description = "状态")
    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "开始时间")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "结束时间")
    private Date endTime;

    @Schema(description = "优先级")
    private Integer priority;

}
