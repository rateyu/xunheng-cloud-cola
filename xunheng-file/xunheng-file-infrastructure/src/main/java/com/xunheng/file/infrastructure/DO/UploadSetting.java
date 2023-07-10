package com.xunheng.file.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("f_upload_setting")
@Table
@ApiModel(value = "上传设置")
public class UploadSetting extends BaseDO {

    private static final long serialVersionUID = 1L;

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
}
