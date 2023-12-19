package com.xunheng.wechat.domain.customerService.model;

import com.alibaba.cola.domain.Entity;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.util.WxMpConfigStorageHolder;

import java.util.Date;

@Data
@Entity
public class WoaMsgEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "消息方向")
    private Integer inOut;

    @ApiModelProperty(value = "消息类型")
    private String msgType;

    @ApiModelProperty(value = "消息详情")
    private String detail;

    public static class WxMsgInOut{
        static final int IN=0;//接收
        static final int OUT=1;//发出
    }

    public WoaMsgEntity() {
    }
    public WoaMsgEntity(WxMpXmlMessage wxMessage) {
        this.openId=wxMessage.getFromUser();
        this.appId= WxMpConfigStorageHolder.get();
        this.inOut = WxMsgInOut.IN;
        this.msgType = wxMessage.getMsgType();
        JSONObject detailJson =  new JSONObject();
        if(WxConsts.XmlMsgType.TEXT.equals(this.msgType)){
            detailJson.put("content",wxMessage.getContent());
        }else if(WxConsts.XmlMsgType.IMAGE.equals(this.msgType)){
            detailJson.put("picUrl",wxMessage.getPicUrl());
            detailJson.put("mediaId",wxMessage.getMediaId());
        }else if(WxConsts.XmlMsgType.VOICE.equals(this.msgType)){
            detailJson.put("format",wxMessage.getFormat());
            detailJson.put("mediaId",wxMessage.getMediaId());
        }else if(WxConsts.XmlMsgType.VIDEO.equals(this.msgType) ||
                WxConsts.XmlMsgType.SHORTVIDEO.equals(this.msgType)){
            detailJson.put("thumbMediaId",wxMessage.getThumbMediaId());
            detailJson.put("mediaId",wxMessage.getMediaId());
        }else if(WxConsts.XmlMsgType.LOCATION.equals(this.msgType)){
            detailJson.put("locationX",wxMessage.getLocationX());
            detailJson.put("locationY",wxMessage.getLocationY());
            detailJson.put("scale",wxMessage.getScale());
            detailJson.put("label",wxMessage.getLabel());
        }else if(WxConsts.XmlMsgType.LINK.equals(this.msgType)){
            detailJson.put("title",wxMessage.getTitle());
            detailJson.put("description",wxMessage.getDescription());
            detailJson.put("url",wxMessage.getUrl());
        }else if(WxConsts.XmlMsgType.EVENT.equals(this.msgType)){
            detailJson.put("event",wxMessage.getEvent());
            detailJson.put("eventKey",wxMessage.getEventKey());
        }
        this.detail = detailJson.toJSONString();
    }
    public static WoaMsgEntity buildOutMsg(String msgType, String openId, JSONObject detail){
        WoaMsgEntity msg = new WoaMsgEntity();
        msg.appId= WxMpConfigStorageHolder.get();
        msg.msgType = msgType;
        msg.openId = openId;
        msg.detail = detail.toJSONString();
        msg.inOut = WxMsgInOut.OUT;
        return msg;
    }

}
