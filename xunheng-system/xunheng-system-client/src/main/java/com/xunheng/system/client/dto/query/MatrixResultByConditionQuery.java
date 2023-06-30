package com.xunheng.system.client.dto.query;

import com.alibaba.cola.dto.Query;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MatrixResultByConditionQuery extends Query {

   @ApiModelProperty(value = "矩阵id")
   private String matrixId;

   @ApiModelProperty(value = "条件列")
   private String conditionColumnTag;

   @ApiModelProperty(value = "条件数据")
   private String conditionColumnData;

   @ApiModelProperty(value = "结果列")
   private String resultColumnTag;
}
