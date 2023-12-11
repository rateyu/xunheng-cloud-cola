package com.xunheng.wechat.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.Index;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "公众号回复规则")
@Table
public class WoaReplyRule extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
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
    @ColumnType(MySqlTypeConstant.DATETIME)
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @ColumnType(MySqlTypeConstant.DATETIME)
    private Date endTime;

    @ApiModelProperty(value = "优先级")
    private Integer priority;

}