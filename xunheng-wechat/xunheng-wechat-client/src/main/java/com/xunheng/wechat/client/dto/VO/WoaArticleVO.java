package com.xunheng.wechat.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaArticleVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "类型")
    private String type;

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
