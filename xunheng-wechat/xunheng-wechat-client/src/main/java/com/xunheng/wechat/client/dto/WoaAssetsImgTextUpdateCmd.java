package com.xunheng.wechat.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialArticleUpdate;
import me.chanjar.weixin.mp.bean.material.WxMpNewsArticle;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class WoaAssetsImgTextUpdateCmd {

    @NotEmpty(message = "图文内容不能为空")
    @Schema(description = "图文内容")
    private WxMpMaterialArticleUpdate form;

    @Schema(description = "appId")
    private String appId;



}
