package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.client.dto.WoaAssetsImgTextUploadCmd;
import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileRemoveCmd;
import com.xunheng.wechat.domain.assets.gateway.WoaAssetsGateway;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号图文上传操作处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaAssetsImgTextUploadCmdExe {

    @Resource
    private WxMpService wxMpService;

    public WxMpMaterialUploadResult execute(WoaAssetsImgTextUploadCmd cmd) {
        try {
            log.info("上传图文素材...");
            wxMpService.switchoverTo(cmd.getAppId());
            WxMpMaterialNews news = new WxMpMaterialNews();
            news.setArticles(cmd.getArticles());
            return wxMpService.getMaterialService().materialNewsUpload(news);
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }

}
