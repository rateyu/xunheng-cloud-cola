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
 * @description: 账号二维码信息DO
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Data
@TableName("wc_wechat_qr_code")
@ApiModel(value = "账号二维码信息")
@Table
public class WechatQrCode extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "二维码类型")
    private String type;

    @ApiModelProperty(value = "场景值id")
    private Integer sceneStr;

    @ApiModelProperty(value = "二维码ticket")
    private String ticket;

    @ApiModelProperty(value = "地址")
    private String url;

    @ApiModelProperty(value = "过期时间")
    @ColumnType(MySqlTypeConstant.DATETIME)
    private Date expireTime;

}