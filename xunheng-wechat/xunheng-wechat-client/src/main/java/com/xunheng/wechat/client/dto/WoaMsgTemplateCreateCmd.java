package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgTemplateCreateCmd {

    @NotBlank(message = "appId不能为空")
    @ApiModelProperty(value = "appId")
    private String appId;

    @NotBlank(message = "模板Id不能为空")
    @ApiModelProperty(value = "模板Id")
    private String templateId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "数据")
    private String data;

    @ApiModelProperty(value = "链接地址")
    private String url;

    @ApiModelProperty(value = "小程序")
    private String miniProgram;

    @ApiModelProperty(value = "状态")
    private String status;

}
