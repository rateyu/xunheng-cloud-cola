package com.xunheng.wechat.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
public class WechatUserVO {

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

    @JsonFormat(pattern = "yyyy-MM-dd")
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

}
