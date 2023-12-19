package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class WoaAssetsMaterialFileUploadCmd {

    @NotEmpty(message = "文件不能为空")
    @ApiModelProperty(value = "文件")
    private MultipartFile file;

    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    private String mediaType;


}
