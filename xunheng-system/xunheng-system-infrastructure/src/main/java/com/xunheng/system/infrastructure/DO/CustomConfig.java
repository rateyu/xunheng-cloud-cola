package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 自定义设置
 * @author hhqkkr
 * @date 2022-05-10 17:28:03
 */
@Data
@TableName("sys_custom_config")
@Schema(description = "自定义设置")
@Table
public class CustomConfig extends BaseDO {

    private static final long serialVersionUID = 1L;

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