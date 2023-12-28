package com.xunheng.wechat.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgFeedRecordVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "对象openId")
    private String openId;

    @Schema(description = "模板id")
    private String templateId;

    @Schema(description = "数据")
    private String data;

    @Schema(description = "链接地址")
    private String url;

    @Schema(description = "小程序")
    private String miniProgram;

    @Schema(description = "推送结果")
    private String feedResult;

}
