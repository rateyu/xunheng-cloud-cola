package com.xunheng.file.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UploadSettingPageQuery extends PageDto {

    @Schema(description = "id")
    private String id;

    @Schema(description = "设置名称")
    private String title;
}
