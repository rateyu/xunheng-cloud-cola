package com.xunheng.base.vo.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 前端element memu中的meta信息
 * @author: hhqkkr
 * @create: 2021-12-18 18:49
 */
@Data
public class MetaVO {

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "整页路由")
    private Boolean fullpage;

    public MetaVO(){

    }

    public MetaVO(String title, String icon, String type, Boolean fullpage) {
        this.title = title;
        this.icon = icon;
        this.type = type;
        this.fullpage = fullpage;
    }
}
