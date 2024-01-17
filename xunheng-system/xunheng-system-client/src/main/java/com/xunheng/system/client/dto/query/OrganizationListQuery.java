package com.xunheng.system.client.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.management.Query;

@Data
public class OrganizationListQuery extends Query {

   @Schema(description = "id")
   private String id;

   @Schema(description = "名称")
   private String title;

   @Schema(description = "类型")
   private String type ;

   @Schema(description = "租户id")
   private String tenantId;
}
