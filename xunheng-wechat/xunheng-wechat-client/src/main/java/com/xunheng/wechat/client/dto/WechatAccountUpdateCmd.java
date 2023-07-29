package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WechatAccountUpdateCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @NotBlank(message = "appId不能为空")
    @ApiModelProperty(value = "appId")
    private String appId;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "appSecret")
    private String appSecret;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "aesKey")
    private String aesKey;

    @ApiModelProperty(value = "类型")
    private Integer type;

}
