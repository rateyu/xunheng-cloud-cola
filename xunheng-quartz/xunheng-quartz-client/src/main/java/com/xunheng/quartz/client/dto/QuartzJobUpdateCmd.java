package com.xunheng.quartz.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class QuartzJobUpdateCmd {

    @Schema(description = "id")
    private String id;

    @Schema(description = "任务类名")
    private String jobClassName;

    @Schema(description = "cron表达式")
    private String cronExpression;

    @Schema(description = "参数")
    private String parameter;

    @Schema(description = "备注")
    private String description;

    @Schema(description = "状态 0正常 -1停止")
    private Integer status;
}
