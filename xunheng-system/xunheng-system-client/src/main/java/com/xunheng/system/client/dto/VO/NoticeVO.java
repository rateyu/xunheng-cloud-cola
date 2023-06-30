package com.xunheng.system.client.dto.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NoticeVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "简介")
    private String description;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "是否公共(0:否 1:是)")
    private Integer isPub;

    @ApiModelProperty(value = "目标用户id")
    private String userId;

    @ApiModelProperty(value = "公告类型")
    private String type;

    @ApiModelProperty(value = "时间描述")
    private String timeStr;

    @ApiModelProperty(value = "是否已读")
    private Integer readFlag;
}
