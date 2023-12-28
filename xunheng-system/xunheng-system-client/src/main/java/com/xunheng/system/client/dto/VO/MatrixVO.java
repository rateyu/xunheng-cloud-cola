package com.xunheng.system.client.dto.VO;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class MatrixVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "列字段列表")
    private List<MatrixColumnVO> columnList;

    @Schema(description = "表数据列表")
    private List<JSONObject> dataList;

}
