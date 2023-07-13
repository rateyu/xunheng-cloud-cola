package com.xunheng.file.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FilePageQuery extends PageDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "目录id")
    private String catalogueId;

    @ApiModelProperty(value = "关键词")
    private String keyword;
}
