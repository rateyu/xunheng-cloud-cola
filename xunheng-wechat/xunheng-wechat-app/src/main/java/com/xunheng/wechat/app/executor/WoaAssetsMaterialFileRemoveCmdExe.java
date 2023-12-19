package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileRemoveCmd;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文件删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaAssetsMaterialFileRemoveCmdExe {

    @Resource
    private WxMpService wxMpService;

    public Boolean execute(WoaAssetsMaterialFileRemoveCmd cmd) {
        try {
            log.info("删除素材，mediaId={}",cmd.getMediaId());
            wxMpService.switchoverTo(cmd.getAppId());
            return wxMpService.getMaterialService().materialDelete(cmd.getMediaId());
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }
}
