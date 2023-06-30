package com.xunheng.quartz.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QuartzJobLogPageQuery extends PageDto {

    @ApiModelProperty(value = "任务id")
    private String jobId;
}
