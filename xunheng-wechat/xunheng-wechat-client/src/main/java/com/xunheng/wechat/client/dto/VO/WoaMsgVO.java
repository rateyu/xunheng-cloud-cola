package com.xunheng.wechat.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "消息方向")
    private Integer inOut;

    @ApiModelProperty(value = "消息类型")
    private String msgType;

    @ApiModelProperty(value = "消息详情")
    private String detail;

}
