package com.xunheng.file.client.dto.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UploadSettingVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "设置名称")
    private String title;

    @ApiModelProperty(value = "上传码")
    private String code;

    @ApiModelProperty(value = "上传目录id")
    private String catalogueId;

    @ApiModelProperty(value = "上传大小限制 单位MB")
    private Integer maxSize;

    @ApiModelProperty(value = "存储方式  FILE_UPLOAD_LOCATION_*")
    private String location;

    @TableField(exist = false)
    @ApiModelProperty(value = "目录名称")
    private String catalogueTitle;

    @TableField(exist = false)
    @ApiModelProperty(value = "完整dir")
    private String fullDir;
}
