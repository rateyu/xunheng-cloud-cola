package com.xunheng.file.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileUploadVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "url")
    private String url;

    @Schema(description = "原文件名")
    private String name;

    @Schema(description = "fKey")
    private String fKey;

}
