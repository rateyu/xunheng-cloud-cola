package com.xunheng.member.domain.member.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Data
@Entity
public class MemberEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "会员名")
    private String name;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别")
    private String sex;

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
