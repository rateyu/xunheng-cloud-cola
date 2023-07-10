package com.xunheng.file.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UploadSettingSaveCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @NotBlank(message = "设置名称不能为空")
    @ApiModelProperty(value = "设置名称")
    private String title;

    @NotBlank(message = "上传码不能为空")
    @ApiModelProperty(value = "上传码")
    private String code;

    @NotBlank(message = "上传目录id不能为空")
    @ApiModelProperty(value = "上传目录id")
    private String catalogueId;

    @ApiModelProperty(value = "上传大小限制 单位MB")
    private Integer maxSize;

    @NotBlank(message = "存储方式不能为空")
    @ApiModelProperty(value = "存储方式  FILE_UPLOAD_LOCATION_*")
    private String location;
}
