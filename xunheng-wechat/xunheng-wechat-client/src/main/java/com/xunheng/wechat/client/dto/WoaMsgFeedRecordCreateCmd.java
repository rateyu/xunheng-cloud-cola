package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgFeedRecordCreateCmd {

    @NotBlank(message = "appId不能为空")
    @ApiModelProperty(value = "appId")
    private String appId;

    @NotBlank(message = "对象openId不能为空")
    @ApiModelProperty(value = "对象openId")
    private String openId;

    @NotBlank(message = "模板id不能为空")
    @ApiModelProperty(value = "模板id")
    private String templateId;

    @ApiModelProperty(value = "数据")
    private String data;

    @ApiModelProperty(value = "链接地址")
    private String url;

    @ApiModelProperty(value = "小程序")
    private String miniProgram;

    @ApiModelProperty(value = "推送结果")
    private String feedResult;

}
