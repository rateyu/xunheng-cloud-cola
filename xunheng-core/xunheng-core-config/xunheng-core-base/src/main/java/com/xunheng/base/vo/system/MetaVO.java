package com.xunheng.base.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @program: xunheng-cloud-cola
 * @description: 前端element memu中的meta信息
 * @author: hhqkkr
 * @create: 2021-12-18 18:49
 */
@Data
public class MetaVO {

    @Schema(description = "菜单标题")
    private String title;

    @Schema(description = "图标")
    private String icon;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "整页路由")
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
