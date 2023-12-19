package com.xunheng.wechat.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.xunheng.base.dto.PageDto;

@Data
public class WoaArticlePageQuery extends PageDto {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "type")
   private String type;

   @ApiModelProperty(value = "标题")
   private String title;
}
