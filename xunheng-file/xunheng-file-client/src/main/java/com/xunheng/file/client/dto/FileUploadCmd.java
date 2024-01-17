package com.xunheng.file.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;

@Data
public class FileUploadCmd {

    @Schema(description = "文件")
    private MultipartFile file;

    @Schema(description = "文件base64编码")
    private String base64;

    @NotBlank(message = "上传编码不能为空")
    @Schema(description = "上传编码")
    private String code;

    @Schema(description = "关联id")
    private String mainId;

}
