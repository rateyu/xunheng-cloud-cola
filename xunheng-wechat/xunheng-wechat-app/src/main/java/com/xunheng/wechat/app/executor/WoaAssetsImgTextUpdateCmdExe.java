package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.client.dto.WoaAssetsImgTextUpdateCmd;
import com.xunheng.wechat.client.dto.WoaAssetsImgTextUploadCmd;
import com.xunheng.wechat.domain.assets.gateway.WoaAssetsGateway;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号图文更新操作处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaAssetsImgTextUpdateCmdExe {

    @Resource
    private WxMpService wxMpService;

    public void execute(WoaAssetsImgTextUpdateCmd cmd) {
        try {
            log.info("更新图文素材...");
            wxMpService.switchoverTo(cmd.getAppId());
            wxMpService.getMaterialService().materialNewsUpdate(cmd.getForm());
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }

}
