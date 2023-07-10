package com.xunheng.file.client.dto.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FileVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "原文件名")
    private String name;

    @ApiModelProperty(value = "存储文件名")
    private String fKey;

    @ApiModelProperty(value = "大小")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long size;

    @ApiModelProperty(value = "文件类型")
    private String type;

    @ApiModelProperty(value = "路径")
    private String url;

    @ApiModelProperty(value = "目录id")
    private String catalogueId;

    @ApiModelProperty(value = "配置id")
    private String settingId;

    @ApiModelProperty(value = "表单主id")
    private String mainId;

    @TableField(exist = false)
    @ApiModelProperty(value = "上传者用户名")
    private String nickname;

    @TableField(exist = false)
    @ApiModelProperty(value = "存储位置")
    private String location;
}
