package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Data
public class SystemConfigSaveCmd {

    @Schema(description = "id")
    private String id;

    @NotBlank(message = "设置类型不能为空")
    @Schema(description = "设置类型")
    private String configType;

    @NotBlank(message = "设置名称不能为空")
    @Schema(description = "设置名称")
    private String configKey;

    @NotBlank(message = "设置值不能为空")
    @Schema(description = "设置值")
    private String configValue;

    @Schema(description = "标题描述")
    private String configTitle;



}
