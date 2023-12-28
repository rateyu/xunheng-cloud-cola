package com.xunheng.wechat.domain.fans.model;

import com.alibaba.cola.domain.Entity;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
@Entity
public class WoaFansEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "openId")
    private String openId;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "城市")
    private String city;

    @Schema(description = "省份")
    private String province;

    @Schema(description = "头像url")
    private String headImgUrl;

    @Schema(description = "订阅时间")
    private Date subscribeTime;

    @Schema(description = "当前是否订阅")
    private Integer subscribe;

    @Schema(description = "unionId")
    private String unionId;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "绑定标签")
    private String tagIdList;

    @Schema(description = "订阅场景")
    private String subscribeScene;

    @Schema(description = "二维码扫描场景描述")
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
