package com.xunheng.system.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserPageQuery extends CustomFilterPageQuery {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "角色")
   private String RoleId;

   @ApiModelProperty(value = "租户")
   private String TenantId;

   @ApiModelProperty(value = "名称")
   private String username;

   @ApiModelProperty(value = "启用/禁用")
   private Integer status;

}
