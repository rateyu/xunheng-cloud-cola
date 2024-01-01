package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 系统信息
 * @author hhqkkr
 * @date 2022-04-29 12:11:49
 */
@Data
@TableName("sys_notice")
@Schema(description = "系统信息")
@Table
public class Notice extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "简介")
    private String description;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "是否公共(0:否 1:是)")
    private Integer isPub;

    @Schema(description = "目标用户id")
    private String userId;

    @Schema(description = "公告类型")
    private String type;

    @TableField(exist=false)
    @Schema(description = "时间描述")
    private String timeStr;

    @TableField(exist=false)
    @Schema(description = "是否已读")
    private Integer readFlag;

}