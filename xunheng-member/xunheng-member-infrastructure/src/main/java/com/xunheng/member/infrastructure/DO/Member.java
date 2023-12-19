package com.xunheng.member.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.Index;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "会员信息")
@Table
public class Member extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "生日")
    @ColumnType(MySqlTypeConstant.DATE)
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