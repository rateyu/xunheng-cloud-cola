package com.xunheng.quartz.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
public class QuartzJobCreateCmd {

    @NotBlank(message = "任务类名不能为空")
    @Schema(description = "任务类名")
    private String jobClassName;

    @NotBlank(message = "cron表达式不能为空")
    @Schema(description = "cron表达式")
    private String cronExpression;

    @Schema(description = "参数")
    private String parameter;

    @Schema(description = "备注")
    private String description;

    @NotNull(message = "状态不能为空")
    @Schema(description = "状态 0正常 -1停止")
    private Integer status;
}
