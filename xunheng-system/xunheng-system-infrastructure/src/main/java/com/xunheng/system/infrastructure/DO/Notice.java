package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统信息
 * @author hhqkkr
 * @date 2022-04-29 12:11:49
 */
@Data
@TableName("sys_notice")
@ApiModel(value = "系统信息")
@Table
public class Notice extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "简介")
    private String description;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "是否公共(0:否 1:是)")
    private Integer isPub;

    @ApiModelProperty(value = "目标用户id")
    private String userId;

    @ApiModelProperty(value = "公告类型")
    private String type;

    @TableField(exist=false)
    @ApiModelProperty(value = "时间描述")
    private String timeStr;

    @TableField(exist=false)
    @ApiModelProperty(value = "是否已读")
    private Integer readFlag;

}