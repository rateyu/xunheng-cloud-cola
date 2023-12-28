package com.xunheng.file.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FilePageQuery extends PageDto {

    @Schema(description = "id")
    private String id;

    @Schema(description = "目录id")
    private String catalogueId;

    @Schema(description = "关键词")
    private String keyword;
}
