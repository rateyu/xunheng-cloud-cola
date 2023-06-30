package com.xunheng.system.domain.customConfig.model;

import com.alibaba.cola.domain.Entity;
import com.xunheng.base.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class CustomConfigEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "是否为个性化设置 0:否 1:是")
    private Integer personal;

    @ApiModelProperty(value = "个性化用户id/系统设置为-1")
    private String userId;

    @ApiModelProperty(value = "设置类型")
    private String configType;

    @ApiModelProperty(value = "设置名称")
    private String configKey;

    @ApiModelProperty(value = "设置值")
    private String configValue;

    @ApiModelProperty(value = "标题描述")
    private String configTitle;
}
