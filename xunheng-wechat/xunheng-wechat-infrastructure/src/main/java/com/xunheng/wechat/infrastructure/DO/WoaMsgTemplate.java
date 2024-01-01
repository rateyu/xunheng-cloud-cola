package com.xunheng.wechat.infrastructure.DO;

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
 * @description: 消息推送模板DO
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Data
@TableName("wc_woa_msg_template")
@Schema(description = "消息推送模板")
@Table
public class WoaMsgTemplate extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Index
    @Schema(description = "appId")
    private String appId;

    @Index
    @Schema(description = "模板Id")
    private String templateId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "数据")
    private String data;

    @Schema(description = "链接地址")
    private String url;

    @Schema(description = "小程序")
    private String miniProgram;

    @Schema(description = "状态")
    private String status;

}