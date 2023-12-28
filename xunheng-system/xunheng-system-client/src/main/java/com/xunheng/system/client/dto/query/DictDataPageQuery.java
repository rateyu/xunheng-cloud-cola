package com.xunheng.system.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DictDataPageQuery extends CustomFilterPageQuery {

   @Schema(description = "id")
   private String id;

   @Schema(description = "字典id")
   private String dictId;

   @Schema(description = "名称")
   private String name;

   @Schema(description = "名称")
   private String type;
}
