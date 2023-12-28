package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Data
public class WoaAssetsMaterialFileUploadCmd {

    @NotEmpty(message = "文件不能为空")
    @Schema(description = "文件")
    private MultipartFile file;

    @Schema(description = "appId")
    private String appId;

    @Schema(description = "文件名称")
    private String fileName;

    @Schema(description = "文件类型")
    private String mediaType;


}
