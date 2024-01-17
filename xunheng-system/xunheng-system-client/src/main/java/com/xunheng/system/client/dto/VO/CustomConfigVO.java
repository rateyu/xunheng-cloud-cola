package com.xunheng.system.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomConfigVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "是否为个性化设置 0:否 1:是")
    private Integer personal;

    @Schema(description = "个性化用户id/系统设置为-1")
    private String userId;

    @Schema(description = "设置类型")
    private String configType;

    @Schema(description = "设置名称")
    private String configKey;

    @Schema(description = "设置值")
    private String configValue;

    @Schema(description = "标题描述")
    private String configTitle;
}
