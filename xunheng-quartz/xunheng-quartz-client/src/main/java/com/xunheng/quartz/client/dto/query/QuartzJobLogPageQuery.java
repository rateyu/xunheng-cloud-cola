package com.xunheng.quartz.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class QuartzJobLogPageQuery extends PageDto {

    @Schema(description = "任务id")
    private String jobId;
}
