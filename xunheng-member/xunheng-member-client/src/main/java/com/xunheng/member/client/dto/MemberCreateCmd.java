package com.xunheng.member.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class MemberCreateCmd {

    @NotBlank(message = "会员名不能为空")
    @ApiModelProperty(value = "会员名")
    private String name;

    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "性别")
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
