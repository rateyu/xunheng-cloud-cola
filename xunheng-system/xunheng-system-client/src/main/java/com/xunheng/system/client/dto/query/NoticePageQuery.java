package com.xunheng.system.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class NoticePageQuery extends CustomFilterPageQuery {

   @Schema(description = "id")
   private String id;

   @Schema(description = "用户ID")
   private String userId;

}
