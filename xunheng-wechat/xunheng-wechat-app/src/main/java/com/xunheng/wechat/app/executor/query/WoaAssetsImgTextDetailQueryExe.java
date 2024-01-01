package com.xunheng.wechat.app.executor.query;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号图文素材详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaAssetsImgTextDetailQueryExe {

    @Resource
    private WxMpService wxMpService;

    public WxMpMaterialNews execute(String appId, String mediaId) {
        try {
            log.info("从API获取图文素材详情,mediaId={}",mediaId);
            wxMpService.switchoverTo(appId);
            return wxMpService.getMaterialService().materialNewsInfo(mediaId);
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }

    }
}

