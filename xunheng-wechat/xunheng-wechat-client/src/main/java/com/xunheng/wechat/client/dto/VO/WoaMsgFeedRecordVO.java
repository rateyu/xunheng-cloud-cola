package com.xunheng.wechat.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgFeedRecordVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "对象openId")
    private String openId;

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
