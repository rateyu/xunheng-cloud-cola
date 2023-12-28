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
 * @description: 微信开发帐号DO
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Data
@TableName("wc_wechat_account")
@Schema(description = "微信开发帐号")
@Table
public class WechatAccount extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @Schema(description = "appId")
    private String appId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "appSecret")
    private String appSecret;

    @Schema(description = "token")
    private String token;

    @Schema(description = "aesKey")
    private String aesKey;

    @Schema(description = "类型")
    private int type;

}