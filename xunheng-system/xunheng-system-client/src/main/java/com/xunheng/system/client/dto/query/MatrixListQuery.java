package com.xunheng.system.client.dto.query;

import com.alibaba.cola.dto.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MatrixListQuery extends Query {

   @Schema(description = "id")
   private String id;

   @Schema(description = "名称")
   private String name;
}
