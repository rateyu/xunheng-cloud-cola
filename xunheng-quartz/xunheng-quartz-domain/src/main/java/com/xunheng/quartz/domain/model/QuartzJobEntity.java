package com.xunheng.quartz.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class QuartzJobEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "任务类名")
    private String jobClassName;

    @ApiModelProperty(value = "cron表达式")
    private String cronExpression;

    @ApiModelProperty(value = "参数")
    private String parameter;

    @ApiModelProperty(value = "备注")
    private String description;

    @ApiModelProperty(value = "状态 0正常 -1停止")
    private Integer status;
}
