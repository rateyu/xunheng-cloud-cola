package com.xunheng.member.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class MemberUpdateCmd {

    @Schema(description = "id")
    private String id;

    @NotBlank(message = "会员名不能为空")
    @Schema(description = "会员名")
    private String name;

    @NotBlank(message = "手机号不能为空")
    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别")
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "生日")
    private Date birth;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "会员等级")
    private String level;

    @Schema(description = "微信openid")
    private String openid;

    @Schema(description = "微信unionid")
    private String unionid;

    @Schema(description = "应用id")
    private String appId;

}
