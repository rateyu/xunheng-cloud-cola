package com.xunheng.quartz.client.dto.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class QuartzJobLogVO {

    @ApiModelProperty(value = "唯一标识")
    private String id;

    @ApiModelProperty(name = "日志信息")
    private String jobMessage;

    @ColumnType(MySqlTypeConstant.TEXT)
    @ApiModelProperty(name = "异常信息")
    private String exceptionInfo;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "状态 0正常 -1异常")
    private Integer status;
}
