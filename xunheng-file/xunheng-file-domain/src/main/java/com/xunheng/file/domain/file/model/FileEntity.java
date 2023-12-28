package com.xunheng.file.domain.file.model;

import com.alibaba.cola.domain.Entity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
public class FileEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "原文件名")
    private String name;

    @Schema(description = "存储文件名")
    private String fKey;

    @Schema(description = "大小")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long size;

    @Schema(description = "文件类型")
    private String type;

    @Schema(description = "路径")
    private String url;

    @Schema(description = "目录id")
    private String catalogueId;

    @Schema(description = "配置id")
    private String settingId;

    @Schema(description = "表单主id")
    private String mainId;

    @Schema(description = "上传人昵称")
    private String nickname;

    @Schema(description = "存储位置")
    private String location;
}
