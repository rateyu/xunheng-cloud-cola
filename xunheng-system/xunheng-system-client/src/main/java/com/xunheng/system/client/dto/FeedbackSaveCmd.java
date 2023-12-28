package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FeedbackSaveCmd {

    @Schema(description = "id")
    private String id;

    @Schema(description = "内容")
    private String content;

}
