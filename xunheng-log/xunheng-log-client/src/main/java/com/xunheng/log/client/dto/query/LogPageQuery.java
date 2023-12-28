package com.xunheng.log.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LogPageQuery extends PageDto {

    @Schema(description = "业务类型")
    private String businessType;

    @Schema(description = "关键词")
    private String keyword;

    @Schema(description = "日期文本开始")
    private String startDate;

    @Schema(description = "日期文本结束")
    private String endDate;
}
