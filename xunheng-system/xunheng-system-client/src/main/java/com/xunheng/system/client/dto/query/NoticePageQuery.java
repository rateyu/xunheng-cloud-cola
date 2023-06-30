package com.xunheng.system.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NoticePageQuery extends CustomFilterPageQuery {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "用户ID")
   private String userId;

}
