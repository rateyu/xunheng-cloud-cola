package com.xunheng.system.domain.notice.model;

import com.alibaba.cola.domain.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
public class NoticeReadEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "公告id")
    private String noticeId;

    @Schema(description = "用户id")
    private String userId;
}
