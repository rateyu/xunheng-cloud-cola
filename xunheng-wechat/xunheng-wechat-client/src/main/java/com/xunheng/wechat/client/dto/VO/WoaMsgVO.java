package com.xunheng.wechat.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaMsgVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "openId")
    private String openId;

    @Schema(description = "消息方向")
    private Integer inOut;

    @Schema(description = "消息类型")
    private String msgType;

    @Schema(description = "消息详情")
    private String detail;

}
