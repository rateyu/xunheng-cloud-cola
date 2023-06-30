package com.xunheng.system.client.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictDataPageQuery extends CustomFilterPageQuery {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "字典id")
   private String dictId;

   @ApiModelProperty(value = "名称")
   private String name;

   @ApiModelProperty(value = "名称")
   private String type;
}
