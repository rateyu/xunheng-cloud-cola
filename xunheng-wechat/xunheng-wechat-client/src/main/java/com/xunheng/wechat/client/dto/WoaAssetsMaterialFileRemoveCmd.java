package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WoaAssetsMaterialFileRemoveCmd {


    @Schema(description = "appId")
    private String appId;

    @Schema(description = "文件id")
    private String mediaId;


}
