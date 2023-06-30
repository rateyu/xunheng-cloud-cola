package com.xunheng.log.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LogPageQuery extends PageDto {

    @ApiModelProperty(name = "业务类型")
    private String businessType;

    @ApiModelProperty(name = "关键词")
    private String keyword;

    @ApiModelProperty(name = "日期文本开始")
    private String startDate;

    @ApiModelProperty(name = "日期文本结束")
    private String endDate;
}
