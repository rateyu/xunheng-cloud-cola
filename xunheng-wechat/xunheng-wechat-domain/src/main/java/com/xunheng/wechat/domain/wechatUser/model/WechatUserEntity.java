package com.xunheng.wechat.domain.wechatUser.model;

import com.alibaba.cola.domain.Entity;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xunheng.base.utils.DateUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Date;

@Data
@Entity
public class WechatUserEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "openId")
    private String openId;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "类型")
    private Integer type;

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

    public WechatUserEntity(){};

    /**
     * 生成公众号粉丝信息
     * @param wxMpUser 公众号同步返回的用户信息
     * @param appId appId
     * @return
     */
    public static WechatUserEntity createWoaFans(WxMpUser wxMpUser, String appId) {
        WechatUserEntity entity  = new WechatUserEntity();
        entity.setOpenId(wxMpUser.getOpenId());
        entity.setAppId(appId);
        entity.setSubscribe(wxMpUser.getSubscribe()?1:0);
        if(wxMpUser.getSubscribe()){
            entity.setNickName(wxMpUser.getNickname());
            entity.setHeadImgUrl(wxMpUser.getHeadImgUrl());
            entity.setSubscribeTime(new Date(wxMpUser.getSubscribeTime()*1000));
            entity.setUnionId(wxMpUser.getUnionId());
            entity.setType(UserType.WX_GZH.getVal());
            entity.setRemark(wxMpUser.getRemark());
            entity.setTagIdList(JSONArray.parseArray(JSONObject.toJSONString(wxMpUser.getTagIds())).toString());
            entity.setSubscribeScene(wxMpUser.getSubscribeScene());
            String qrScene =  wxMpUser.getQrScene();
            entity.setQrSceneStr(!StringUtils.hasText(qrScene) ? wxMpUser.getQrSceneStr() : qrScene);
        }
        return entity;
    }

    public static WechatUserEntity createWmaUser(String appId,String openId,String unionId){
        WechatUserEntity entity  = new WechatUserEntity();
        entity.setType(UserType.WX_XCX.getVal());
        entity.setOpenId(openId);
        entity.setAppId(appId);
        entity.setUnionId(unionId);
        Instant instant = Instant.now();
        long timestamp = instant.toEpochMilli();
        entity.setNickName("新用户_"+ timestamp+openId.substring(0,5));//初始化用户名
        entity.setHeadImgUrl("https://i.postimg.cc/c42kD1Qf/image.png");//初始化头像
        return entity;
    }
}
