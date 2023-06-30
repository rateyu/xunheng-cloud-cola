package com.xunheng.system.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class PersonalConfigSaveCmd {

    @NotBlank(message = "设置名称不能为空")
    @ApiModelProperty(value = "设置名称")
    private String configKey;

    @NotBlank(message = "设置值不能为空")
    @ApiModelProperty(value = "设置值")
    private String configValue;

}
