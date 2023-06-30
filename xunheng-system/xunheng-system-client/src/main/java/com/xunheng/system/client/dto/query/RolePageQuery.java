package com.xunheng.system.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RolePageQuery extends CustomFilterPageQuery {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "名称")
   private String name;

   @ApiModelProperty(value = "描述")
   private String description;
}
