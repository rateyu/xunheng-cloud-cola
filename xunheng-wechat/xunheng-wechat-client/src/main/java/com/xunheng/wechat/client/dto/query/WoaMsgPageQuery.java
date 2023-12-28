package com.xunheng.wechat.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.xunheng.base.dto.PageDto;

@Data
public class WoaMsgPageQuery extends PageDto {

   @Schema(description = "id")
   private String id;

   @Schema(description = "appId")
   private String appId;

   @Schema(description = "openId")
   private String openId;
}
