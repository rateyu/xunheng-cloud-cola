package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WechatQrCodeUpdateCmd {

    @ApiModelProperty(value = "id")
    private String id;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "过期时间")
    private Date expireTime;

}
