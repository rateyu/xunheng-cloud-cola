package com.xunheng.system.client.dto.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FeedbackVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "内容")
    private String content;
}
