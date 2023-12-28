package com.xunheng.quartz.client.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class QuartzJobLogCreateCmd {

    @Schema(description = "唯一标识")
    private String id;

    @Schema(description = "删除标志 默认0")
    private Integer delFlag;

    @Schema(description = "任务id")
    private String jobId;

    @Schema(description = "日志信息")
    private String jobMessage;

    @Schema(description = "异常信息")
    private String exceptionInfo;

    @Schema(description = "开始时间")
    private Date startTime;

    @Schema(description = "停止时间")
    private Date stopTime;

    @Schema(description = "状态 0正常 -1异常")
    private Integer status;
}
