package com.xunheng.system.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.management.Query;

@Data
public class OrganizationListQuery extends Query {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "名称")
   private String title;

   @ApiModelProperty(value = "类型")
   private String type ;

   @ApiModelProperty(value = "租户id")
   private String tenantId;
}
