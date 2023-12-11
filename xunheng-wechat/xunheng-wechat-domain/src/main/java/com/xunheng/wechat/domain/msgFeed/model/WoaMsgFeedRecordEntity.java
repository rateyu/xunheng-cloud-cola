package com.xunheng.wechat.domain.msgFeed.model;

import com.alibaba.cola.domain.Entity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class WoaMsgFeedRecordEntity {

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
