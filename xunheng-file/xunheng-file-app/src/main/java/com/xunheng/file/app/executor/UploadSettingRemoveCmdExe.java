package com.xunheng.file.app.executor;

import com.xunheng.file.domain.uploadSetting.gateway.UploadSettingGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置删除操作处理器
 * @author: hhqkkr
 * @date: 2023/7/10 13:25
 */
@Component
public class UploadSettingRemoveCmdExe {

    @Resource
    UploadSettingGateway uploadSettingGateway;

    public void execute(String id) {
        uploadSettingGateway.remove(id);
    }
}
