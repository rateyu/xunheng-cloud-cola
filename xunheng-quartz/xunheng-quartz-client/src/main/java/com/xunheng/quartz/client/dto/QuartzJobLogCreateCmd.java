package com.xunheng.quartz.client.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class QuartzJobLogCreateCmd {

    @ApiModelProperty(value = "唯一标识")
    private String id;

    @ApiModelProperty(value = "删除标志 默认0")
    private Integer delFlag;

    @ApiModelProperty(value = "任务id")
    private String jobId;

    @ApiModelProperty(name = "日志信息")
    private String jobMessage;

    @ApiModelProperty(name = "异常信息")
    private String exceptionInfo;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "停止时间")
    private Date stopTime;

    @ApiModelProperty(value = "状态 0正常 -1异常")
    private Integer status;
}
