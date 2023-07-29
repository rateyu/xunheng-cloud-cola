package com.xunheng.wechat.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WechatAccountVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appId")
    private String appId;

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
