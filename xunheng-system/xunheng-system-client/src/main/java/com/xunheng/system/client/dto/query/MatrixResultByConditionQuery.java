package com.xunheng.system.client.dto.query;

import com.alibaba.cola.dto.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MatrixResultByConditionQuery extends Query {

   @Schema(description = "矩阵id")
   private String matrixId;

   @Schema(description = "条件列")
   private String conditionColumnTag;

   @Schema(description = "条件数据")
   private String conditionColumnData;

   @Schema(description = "结果列")
   private String resultColumnTag;
}
