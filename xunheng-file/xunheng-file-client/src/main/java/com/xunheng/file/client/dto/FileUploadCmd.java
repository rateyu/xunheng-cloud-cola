package com.xunheng.file.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Data
public class FileUploadCmd {

    @ApiModelProperty(value = "文件")
    private MultipartFile file;

    @ApiModelProperty(value = "文件base64编码")
    private String base64;

    @NotBlank(message = "上传编码不能为空")
    @ApiModelProperty(value = "上传编码")
    private String code;

    @ApiModelProperty(value = "关联id")
    private String mainId;

}
