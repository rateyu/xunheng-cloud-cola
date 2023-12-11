package com.xunheng.wechat.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Data
public class WoaFansVO {

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

    @JsonFormat(pattern = "yyyy-MM-dd")
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

}
