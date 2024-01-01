package com.xunheng.wechat.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.ColumnType;
import com.tangzc.mpe.autotable.annotation.Table;
import com.tangzc.mpe.autotable.annotation.Index;
import com.tangzc.mpe.autotable.strategy.mysql.data.MysqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户DO
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Data
@TableName("wc_wechat_user")
@Schema(description = "微信用户")
@Table
public class WechatUser extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @Schema(description = "openId")
    private String openId;

    @Index
    @Schema(description = "appId")
    private String appId;

    @Schema(description = "用户类型 小程序/公众号")
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

    @ColumnType(MysqlTypeConstant.DATE)
    @Schema(description = "订阅时间")
    private Date subscribeTime;

    @Schema(description = "当前是否订阅")
    private Integer subscribe;

    @Index
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