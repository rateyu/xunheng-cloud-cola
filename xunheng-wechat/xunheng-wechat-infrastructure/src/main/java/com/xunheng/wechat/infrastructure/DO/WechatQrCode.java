package com.xunheng.wechat.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.ColumnType;
import com.tangzc.mpe.autotable.annotation.Table;
import com.tangzc.mpe.autotable.annotation.Index;
import com.tangzc.mpe.autotable.strategy.mysql.data.MysqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.xunheng.base.constant.CommonConstant;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息DO
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Data
@TableName("wc_wechat_qr_code")
@Schema(description = "账号二维码信息")
@Table
public class WechatQrCode extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @Schema(description = "appId")
    private String appId;

    @Schema(description = "二维码类型")
    private String type;

    @Schema(description = "场景值id")
    private Integer sceneStr;

    @Schema(description = "二维码ticket")
    private String ticket;

    @Schema(description = "地址")
    private String url;

    @Schema(description = "过期时间")
    @ColumnType(MysqlTypeConstant.DATETIME)
    private Date expireTime;

}