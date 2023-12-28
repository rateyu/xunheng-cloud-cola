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
 * @description: 消息推送日志DO
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
@Data
@TableName("wc_woa_msg_feed_record")
@Schema(description = "消息推送日志")
@Table
public class WoaMsgFeedRecord extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @Schema(description = "appId")
    private String appId;

    @Index
    @Schema(description = "对象openId")
    private String openId;

    @Index
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