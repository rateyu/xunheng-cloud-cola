package com.xunheng.wechat.domain.customerService.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class WoaReplyRuleEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "规则名称")
    private String ruleName;

    @Schema(description = "匹配关键词")
    private String matchValue;

    @Schema(description = "精准匹配")
    private Integer exactMatch;

    @Schema(description = "回复类型")
    private String replyType;

    @Schema(description = "回复内容")
    private String replyContent;

    @Schema(description = "状态")
    private Integer status;

    @Schema(description = "开始时间")
    private Date startTime;

    @Schema(description = "结束时间")
    private Date endTime;

    @Schema(description = "优先级")
    private Integer priority;

}
