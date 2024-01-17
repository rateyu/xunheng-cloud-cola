package com.xunheng.file.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("f_upload_setting")
@Table
@Schema(description = "上传设置")
public class UploadSetting extends BaseDO {

    private static final long serialVersionUID = 1L;

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
}
