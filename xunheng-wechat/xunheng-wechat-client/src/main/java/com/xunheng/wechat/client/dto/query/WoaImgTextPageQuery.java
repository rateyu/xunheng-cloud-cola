package com.xunheng.wechat.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WoaImgTextPageQuery extends PageDto {

   @Schema(description = "id")
   private String id;

   @Schema(description = "appId")
   private String appId;

}
