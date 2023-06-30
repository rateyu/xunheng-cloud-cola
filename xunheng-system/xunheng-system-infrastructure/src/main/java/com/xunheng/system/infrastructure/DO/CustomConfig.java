package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 自定义设置
 * @author hhqkkr
 * @date 2022-05-10 17:28:03
 */
@Data
@TableName("sys_custom_config")
@ApiModel(value = "自定义设置")
@Table
public class CustomConfig extends BaseDO {

    private static final long serialVersionUID = 1L;

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