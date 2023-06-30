package com.xunheng.system.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TenantAuthRecordPageQuery extends CustomFilterPageQuery {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "租户名称")
   private String tenantName;
}
