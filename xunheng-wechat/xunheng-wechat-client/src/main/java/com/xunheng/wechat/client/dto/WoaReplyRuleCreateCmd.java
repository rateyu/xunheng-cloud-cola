package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaReplyRuleCreateCmd {

    @ApiModelProperty(value = "appId")
    private String appId;

    @NotBlank(message = "规则名称不能为空")
    @ApiModelProperty(value = "规则名称")
    private String ruleName;

    @NotBlank(message = "匹配关键词不能为空")
    @ApiModelProperty(value = "匹配关键词")
    private String matchValue;

    @ApiModelProperty(value = "精准匹配")
    private Integer exactMatch;

    @ApiModelProperty(value = "回复类型")
    private String replyType;

    @NotBlank(message = "回复内容不能为空")
    @ApiModelProperty(value = "回复内容")
    private String replyContent;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "优先级")
    private Integer priority;

}
