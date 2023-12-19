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
import java.math.BigDecimal;
import java.util.Date;
import com.xunheng.base.constant.CommonConstant;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板DO
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Data
@TableName("wc_woa_msg_template")
@ApiModel(value = "消息推送模板")
@Table
public class WoaMsgTemplate extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @ApiModelProperty(value = "appId")
    private String appId;

    @Index
    @ApiModelProperty(value = "模板Id")
    private String templateId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "数据")
    private String data;

    @ApiModelProperty(value = "链接地址")
    private String url;

    @ApiModelProperty(value = "小程序")
    private String miniProgram;

    @ApiModelProperty(value = "状态")
    private String status;

}