package com.xunheng.file.client.dto.query;

import com.xunheng.base.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UploadSettingPageQuery extends PageDto {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "设置名称")
    private String title;
}
