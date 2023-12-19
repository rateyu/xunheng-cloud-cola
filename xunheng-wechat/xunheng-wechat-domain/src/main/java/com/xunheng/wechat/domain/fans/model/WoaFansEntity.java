package com.xunheng.wechat.domain.fans.model;

import com.alibaba.cola.domain.Entity;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
@Entity
public class WoaFansEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "头像url")
    private String headImgUrl;

    @ApiModelProperty(value = "订阅时间")
    private Date subscribeTime;

    @ApiModelProperty(value = "当前是否订阅")
    private Integer subscribe;

    @ApiModelProperty(value = "unionId")
    private String unionId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "绑定标签")
    private String tagIdList;

    @ApiModelProperty(value = "订阅场景")
    private String subscribeScene;

    @ApiModelProperty(value = "二维码扫描场景描述")
    private String qrSceneStr;

    public WoaFansEntity(){};

    public WoaFansEntity(WxMpUser wxMpUser, String appId) {
        this.openId = wxMpUser.getOpenId();
        this.appId = appId;
        this.subscribe=wxMpUser.getSubscribe()?1:0;
        if(wxMpUser.getSubscribe()){
            this.nickName = wxMpUser.getNickname();
            this.headImgUrl = wxMpUser.getHeadImgUrl();
            this.subscribeTime = new Date(wxMpUser.getSubscribeTime()*1000);
            this.unionId=wxMpUser.getUnionId();
            this.remark=wxMpUser.getRemark();
            this.tagIdList= JSONArray.parseArray(JSONObject.toJSONString(wxMpUser.getTagIds())).toString();
            this.subscribeScene=wxMpUser.getSubscribeScene();
            String qrScene =  wxMpUser.getQrScene();
            this.qrSceneStr= !StringUtils.hasText(qrScene) ? wxMpUser.getQrSceneStr() : qrScene;
        }
    }
}
