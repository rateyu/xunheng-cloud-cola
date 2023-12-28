package com.xunheng.system.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserPageQuery extends CustomFilterPageQuery {

   @Schema(description = "id")
   private String id;

   @Schema(description = "角色")
   private String RoleId;

   @Schema(description = "租户")
   private String TenantId;

   @Schema(description = "名称")
   private String username;

   @Schema(description = "启用/禁用")
   private Integer status;

}
