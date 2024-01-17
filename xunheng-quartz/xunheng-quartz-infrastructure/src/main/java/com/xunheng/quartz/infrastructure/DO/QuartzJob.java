package com.xunheng.quartz.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("qrtz_quartz_job")
@Table
@Schema(description = "定时任务")
public class QuartzJob extends BaseDO {

    private static final long serialVersionUID = 1L;

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
