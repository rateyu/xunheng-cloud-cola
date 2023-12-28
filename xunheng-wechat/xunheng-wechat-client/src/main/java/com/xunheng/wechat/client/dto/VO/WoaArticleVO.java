package com.xunheng.wechat.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.math.BigDecimal;

@Data
public class WoaArticleVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "标签")
    private String tags;

    @Schema(description = "摘要")
    private String summary;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "目录")
    private String category;

    @Schema(description = "二级目录")
    private String subCategory;

    @Schema(description = "打开次数")
    private Integer openCount;

    @Schema(description = "打开链接")
    private String targetLink;

    @Schema(description = "图像")
    private String image;

}
