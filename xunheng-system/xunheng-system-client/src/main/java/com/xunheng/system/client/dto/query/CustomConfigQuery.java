package com.xunheng.system.client.dto.query;

import com.alibaba.cola.dto.Query;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomConfigQuery extends Query {

   @ApiModelProperty(value = "用户id")
   private String userId;

   @ApiModelProperty(value = "key")
   private String configKey;

}
