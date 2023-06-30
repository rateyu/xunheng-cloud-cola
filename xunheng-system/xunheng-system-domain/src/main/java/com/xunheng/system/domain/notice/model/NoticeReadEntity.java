package com.xunheng.system.domain.notice.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class NoticeReadEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "公告id")
    private String noticeId;

    @ApiModelProperty(value = "用户id")
    private String userId;
}
