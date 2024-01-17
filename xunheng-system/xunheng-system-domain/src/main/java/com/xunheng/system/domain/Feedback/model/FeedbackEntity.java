package com.xunheng.system.domain.Feedback.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
public class FeedbackEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "内容")
    private String content;
}
