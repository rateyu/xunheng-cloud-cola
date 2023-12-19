package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WoaAssetsMaterialFileRemoveCmd {


    @ApiModelProperty(value = "appId")
    private String appId;

    @ApiModelProperty(value = "文件id")
    private String mediaId;


}
