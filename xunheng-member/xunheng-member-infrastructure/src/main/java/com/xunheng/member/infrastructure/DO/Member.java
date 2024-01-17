package com.xunheng.member.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.ColumnType;
import com.tangzc.mpe.autotable.annotation.Table;
import com.tangzc.mpe.autotable.annotation.Index;
import com.tangzc.mpe.autotable.strategy.mysql.data.MysqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.xunheng.base.constant.CommonConstant;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息DO
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Data
@TableName("m_member")
@Schema(description = "会员信息")
@Table
public class Member extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "会员名")
    private String name;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "生日")
    @ColumnType(MysqlTypeConstant.DATE)
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