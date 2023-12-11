package com.xunheng.wechat.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.chanjar.weixin.mp.bean.material.WxMpNewsArticle;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class WoaAssetsImgTextUploadCmd {

    @NotEmpty(message = "图文内容不能为空")
    @ApiModelProperty(value = "图文内容")
    private List<WxMpNewsArticle> articles;

    @ApiModelProperty(value = "appId")
    private String appId;



}
