package com.xunheng.file.domain.uploadSetting.model;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
public class UploadSettingEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "设置名称")
    private String title;

    @Schema(description = "上传码")
    private String code;

    @Schema(description = "上传目录id")
    private String catalogueId;

    @Schema(description = "上传大小限制 单位MB")
    private Integer maxSize;

    @Schema(description = "存储方式  FILE_UPLOAD_LOCATION_*")
    private String location;

    @Schema(description = "目录名称")
    private String catalogueTitle;

    @Schema(description = "完整dir")
    private String fullDir;
}
