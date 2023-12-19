package com.xunheng.member.domain.member.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class MemberEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "会员名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "生日")
    private Date birth;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "会员等级")
    private String level;

    @ApiModelProperty(value = "微信openid")
    private String openid;

    @ApiModelProperty(value = "微信unionid")
    private String unionid;

    @ApiModelProperty(value = "应用id")
    private String appId;

}
