package com.xunheng.system.domain.customConfig.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.base.constant.CommonConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class CustomConfigEntity {

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
