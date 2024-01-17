package com.xunheng.file.client.dto.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UploadSettingVO {

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

    @TableField(exist = false)
    @Schema(description = "目录名称")
    private String catalogueTitle;

    @TableField(exist = false)
    @Schema(description = "完整dir")
    private String fullDir;
}
