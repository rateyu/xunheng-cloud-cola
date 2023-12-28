package com.xunheng.wechat.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.Index;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.xunheng.base.constant.CommonConstant;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则DO
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Data
@TableName("wc_woa_reply_rule")
@Schema(description = "公众号回复规则")
@Table
public class WoaReplyRule extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
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
    @ColumnType(MySqlTypeConstant.DATETIME)
    private Date startTime;

    @Schema(description = "结束时间")
    @ColumnType(MySqlTypeConstant.DATETIME)
    private Date endTime;

    @Schema(description = "优先级")
    private Integer priority;

}