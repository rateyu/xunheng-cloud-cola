package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WoaArticleSaveCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "类型")
    private String type;

    @NotBlank(message = "标题不能为空")
    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "标签")
    private String tags;

    @ApiModelProperty(value = "摘要")
    private String summary;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "目录")
    private String category;

    @ApiModelProperty(value = "二级目录")
    private String subCategory;

    @ApiModelProperty(value = "打开次数")
    private Integer openCount;

    @ApiModelProperty(value = "打开链接")
    private String targetLink;

    @ApiModelProperty(value = "图像")
    private String image;

}
