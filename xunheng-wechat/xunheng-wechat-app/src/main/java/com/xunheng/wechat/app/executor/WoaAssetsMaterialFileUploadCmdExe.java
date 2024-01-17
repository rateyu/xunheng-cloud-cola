package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileUploadCmd;
import com.xunheng.wechat.domain.assets.gateway.WoaAssetsGateway;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterial;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文件上传操作处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaAssetsMaterialFileUploadCmdExe {

    @Resource
    private WxMpService wxMpService;

    public WxMpMaterialUploadResult execute(WoaAssetsMaterialFileUploadCmd cmd) {
        try {
            log.info("上传媒体素材：{}",cmd.getFileName());
            wxMpService.switchoverTo(cmd.getAppId());
            String originalFilename=cmd.getFile().getOriginalFilename();
            File tempFile = null;
            tempFile = File.createTempFile(cmd.getFileName()+"--", Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf(".")));
            cmd.getFile().transferTo(tempFile);
            WxMpMaterial wxMaterial = new WxMpMaterial();
            wxMaterial.setFile(tempFile);
            wxMaterial.setName(cmd.getFileName());
            if(WxConsts.MediaFileType.VIDEO.equals(cmd.getMediaType())){
                wxMaterial.setVideoTitle(cmd.getFileName());
            }
            WxMpMaterialUploadResult res = wxMpService.getMaterialService().materialFileUpload(cmd.getMediaType(),wxMaterial);
            tempFile.deleteOnExit();
            return res;
        } catch (IOException | WxErrorException e) {
            throw new RuntimeException(e);
        }
    }
}
