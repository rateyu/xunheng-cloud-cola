package com.xunheng.system.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FeedbackSaveCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "内容")
    private String content;

}
