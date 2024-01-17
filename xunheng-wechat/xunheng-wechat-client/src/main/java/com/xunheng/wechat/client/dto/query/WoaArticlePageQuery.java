package com.xunheng.wechat.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.xunheng.base.dto.PageDto;

@Data
public class WoaArticlePageQuery extends PageDto {

   @Schema(description = "id")
   private String id;

   @Schema(description = "type")
   private String type;

   @Schema(description = "标题")
   private String title;
}
