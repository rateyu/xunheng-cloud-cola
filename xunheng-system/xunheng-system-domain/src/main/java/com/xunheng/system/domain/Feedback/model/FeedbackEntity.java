package com.xunheng.system.domain.Feedback.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class FeedbackEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "内容")
    private String content;
}
