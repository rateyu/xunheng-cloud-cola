package com.xunheng.system.client.dto.query;

import com.alibaba.cola.dto.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomConfigQuery extends Query {

   @Schema(description = "用户id")
   private String userId;

   @Schema(description = "key")
   private String configKey;

}
