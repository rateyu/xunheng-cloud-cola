package com.xunheng.wechat.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.Index;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝DO
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Data
@TableName("wc_woa_fans")
@ApiModel(value = "公众号粉丝")
@Table
public class WoaFans extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @ApiModelProperty(value = "openId")
    private String openId;

    @Index
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

    @ColumnType(MySqlTypeConstant.DATE)
    @ApiModelProperty(value = "订阅时间")
    private Date subscribeTime;

    @ApiModelProperty(value = "当前是否订阅")
    private Integer subscribe;

    @Index
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