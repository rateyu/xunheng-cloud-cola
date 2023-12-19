package com.xunheng.wechat.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.Index;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "公众号文章")
@Table
public class WoaArticle extends BaseDO {

    private static final long serialVersionUID = 1L;

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