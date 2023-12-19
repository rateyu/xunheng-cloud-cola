package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WechatQrCodeCreateCmd {

    @NotBlank(message = "appId不能为空")
    @ApiModelProperty(value = "appId")
    private String appId;

    @NotBlank(message = "二维码类型不能为空")
    @ApiModelProperty(value = "二维码类型")
    private String type;

    @ApiModelProperty(value = "场景值id")
    private Integer sceneStr;

    @ApiModelProperty(value = "二维码ticket")
    private String ticket;

    @ApiModelProperty(value = "地址")
    private String url;

    @ApiModelProperty(value = "失效时间/秒")
    private Integer expireSeconds;

}
