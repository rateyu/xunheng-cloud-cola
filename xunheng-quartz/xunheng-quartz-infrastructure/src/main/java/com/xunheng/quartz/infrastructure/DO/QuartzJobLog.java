package com.xunheng.quartz.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseNoneLogicDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("qrtz_quartz_job_log")
@Table
@Schema(description = "定时任务日志")
public class QuartzJobLog extends BaseNoneLogicDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "任务id")
    private String jobId;

    @Schema(description = "日志信息")
    private String jobMessage;

    @ColumnType(MySqlTypeConstant.TEXT)
    @Schema(description = "异常信息")
    private String exceptionInfo;

    @Schema(description = "开始时间")
    private Date startTime;

    @Schema(description = "停止时间")
    private Date stopTime;

    @Schema(description = "状态 0正常 -1异常")
    private Integer status;

}
