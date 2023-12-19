package com.xunheng.wechat.domain.account.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class WechatQrCodeEntity {

    @ApiModelProperty(value = "id")
    private String id;

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
    private Date expireTime;

}
