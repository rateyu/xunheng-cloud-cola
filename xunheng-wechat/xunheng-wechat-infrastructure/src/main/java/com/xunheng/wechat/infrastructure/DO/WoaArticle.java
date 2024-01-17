package com.xunheng.wechat.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.ColumnType;
import com.tangzc.mpe.autotable.annotation.Table;
import com.tangzc.mpe.autotable.annotation.Index;
import com.tangzc.mpe.autotable.strategy.mysql.data.MysqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.xunheng.base.constant.CommonConstant;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章DO
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
@Data
@TableName("wc_woa_article")
@Schema(description = "公众号文章")
@Table
public class WoaArticle extends BaseDO {

    private static final long serialVersionUID = 1L;

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