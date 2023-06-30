package com.xunheng.system.client.dto;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MatrixDataSaveCmd {

    @ApiModelProperty(value = "matrixId")
    private String id;

    @ApiModelProperty(value = "插入的行")
    JSONArray insertRecords;

    @ApiModelProperty(value = "删除的行")
    JSONArray removeRecords;

    @ApiModelProperty(value = "更新的行")
    JSONArray updateRecords;

}
