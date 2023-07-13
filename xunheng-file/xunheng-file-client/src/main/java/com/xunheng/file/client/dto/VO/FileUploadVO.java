package com.xunheng.file.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileUploadVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "原文件名")
    private String name;

    @ApiModelProperty(value = "fKey")
    private String fKey;

}
