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
 * @description: 公众号消息DO
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
@Data
@TableName("wc_woa_msg")
@ApiModel(value = "公众号消息")
@Table
public class WoaMsg extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @ApiModelProperty(value = "appId")
    private String appId;

    @Index
    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "消息方向")
    private Integer inOut;

    @ApiModelProperty(value = "消息类型")
    private String msgType;

    @ApiModelProperty(value = "消息详情")
    private String detail;

}