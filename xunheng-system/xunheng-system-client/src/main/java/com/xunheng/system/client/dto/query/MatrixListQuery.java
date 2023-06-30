package com.xunheng.system.client.dto.query;

import com.alibaba.cola.dto.Query;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MatrixListQuery extends Query {

   @ApiModelProperty(value = "id")
   private String id;

   @ApiModelProperty(value = "名称")
   private String name;
}
