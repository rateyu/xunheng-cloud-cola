package com.xunheng.system.domain.notice.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
public class NoticeEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "简介")
    private String description;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "是否公共(0:否 1:是)")
    private Integer isPub;

    @Schema(description = "目标用户id")
    private String userId;

    @Schema(description = "公告类型")
    private String type;

    @Schema(description = "时间描述")
    private String timeStr;

    @Schema(description = "是否已读")
    private Integer readFlag;
}
