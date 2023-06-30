package com.xunheng.quartz.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class QuartzJobCreateCmd {

    @NotBlank(message = "任务类名不能为空")
    @ApiModelProperty(value = "任务类名")
    private String jobClassName;

    @NotBlank(message = "cron表达式不能为空")
    @ApiModelProperty(value = "cron表达式")
    private String cronExpression;

    @ApiModelProperty(value = "参数")
    private String parameter;

    @ApiModelProperty(value = "备注")
    private String description;

    @NotNull(message = "状态不能为空")
    @ApiModelProperty(value = "状态 0正常 -1停止")
    private Integer status;
}
