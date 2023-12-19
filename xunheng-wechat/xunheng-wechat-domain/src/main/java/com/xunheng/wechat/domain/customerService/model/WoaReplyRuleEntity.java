package com.xunheng.wechat.domain.customerService.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class WoaReplyRuleEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "规则名称")
    private String ruleName;

    @ApiModelProperty(value = "匹配关键词")
    private String matchValue;

    @ApiModelProperty(value = "精准匹配")
    private Integer exactMatch;

    @ApiModelProperty(value = "回复类型")
    private String replyType;

    @ApiModelProperty(value = "回复内容")
    private String replyContent;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "优先级")
    private Integer priority;

}
