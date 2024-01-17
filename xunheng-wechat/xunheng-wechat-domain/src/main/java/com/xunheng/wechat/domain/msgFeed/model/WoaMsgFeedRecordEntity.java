package com.xunheng.wechat.domain.msgFeed.model;

import com.alibaba.cola.domain.Entity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class WoaMsgFeedRecordEntity {

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

    public WoaMsgFeedRecordEntity() {
    }

    public WoaMsgFeedRecordEntity(WxMpTemplateMessage msg, String appId, String feedResult) {
        this.appId = appId;
        this.openId = msg.getToUser();
        this.templateId = msg.getTemplateId();
        this.url = msg.getUrl();
        this.miniProgram = JSONObject.parseObject(JSON.toJSONString(msg.getMiniProgram())).toJSONString();
        this.data = JSONArray.parseArray(JSON.toJSONString(msg.getData())).toJSONString();
        this.feedResult = feedResult;
    }

}
