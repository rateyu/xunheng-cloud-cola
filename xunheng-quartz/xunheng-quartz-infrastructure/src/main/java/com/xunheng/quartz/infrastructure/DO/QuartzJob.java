package com.xunheng.quartz.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("qrtz_quartz_job")
@Table
@ApiModel(value = "定时任务")
public class QuartzJob extends BaseDO {

    private static final long serialVersionUID = 1L;

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
