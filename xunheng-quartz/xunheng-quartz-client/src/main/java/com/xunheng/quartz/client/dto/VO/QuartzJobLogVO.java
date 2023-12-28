package com.xunheng.quartz.client.dto.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class QuartzJobLogVO {

    @Schema(description = "唯一标识")
    private String id;

    @Schema(description = "日志信息")
    private String jobMessage;

    @ColumnType(MySqlTypeConstant.TEXT)
    @Schema(description = "异常信息")
    private String exceptionInfo;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "开始时间")
    private Date startTime;

    @Schema(description = "状态 0正常 -1异常")
    private Integer status;
}
