package com.xunheng.system.client.dto;

import com.alibaba.fastjson.JSONArray;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MatrixDataSaveCmd {

    @Schema(description = "matrixId")
    private String id;

    @Schema(description = "插入的行")
    JSONArray insertRecords;

    @Schema(description = "删除的行")
    JSONArray removeRecords;

    @Schema(description = "更新的行")
    JSONArray updateRecords;

}
