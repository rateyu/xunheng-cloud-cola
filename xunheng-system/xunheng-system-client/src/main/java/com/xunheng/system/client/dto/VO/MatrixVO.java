package com.xunheng.system.client.dto.VO;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class MatrixVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "列字段列表")
    private List<MatrixColumnVO> columnList;

    @ApiModelProperty(value = "表数据列表")
    private List<JSONObject> dataList;

}
