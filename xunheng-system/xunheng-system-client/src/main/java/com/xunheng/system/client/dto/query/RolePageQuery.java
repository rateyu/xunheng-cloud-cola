package com.xunheng.system.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RolePageQuery extends CustomFilterPageQuery {

   @Schema(description = "id")
   private String id;

   @Schema(description = "名称")
   private String name;

   @Schema(description = "描述")
   private String description;
}
