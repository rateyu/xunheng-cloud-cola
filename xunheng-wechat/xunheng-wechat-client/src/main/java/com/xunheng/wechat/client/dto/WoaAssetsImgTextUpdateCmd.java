package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialArticleUpdate;
import me.chanjar.weixin.mp.bean.material.WxMpNewsArticle;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class WoaAssetsImgTextUpdateCmd {

    @NotEmpty(message = "图文内容不能为空")
    @ApiModelProperty(value = "图文内容")
    private WxMpMaterialArticleUpdate form;

    @ApiModelProperty(value = "appId")
    private String appId;



}
