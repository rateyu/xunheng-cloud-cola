package com.xunheng.member.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class MemberVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "会员名")
    private String name;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别")
    private String sex;

    @JsonFormat(pattern = "yyyy-MM-dd")
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
