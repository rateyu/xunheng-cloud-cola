package com.xunheng.file.app.executor;

import com.xunheng.file.app.assembler.UploadSettingAssembler;
import com.xunheng.file.client.dto.UploadSettingSaveCmd;
import com.xunheng.file.client.dto.VO.UploadSettingVO;
import com.xunheng.file.domain.uploadSetting.gateway.UploadSettingGateway;
import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置保存操作处理器
 * @author: hhqkkr
 * @date: 2023/7/10 13:23
 */
@Component
public class UploadSettingSaveCmdExe {

    @Resource
    UploadSettingGateway uploadSettingGateway;

    public UploadSettingVO execute(UploadSettingSaveCmd cmd) {
        UploadSettingEntity entity = uploadSettingGateway.saveOrUpdate(UploadSettingAssembler.toEntity(cmd));
        return UploadSettingAssembler.toVO(entity);
    }
}
