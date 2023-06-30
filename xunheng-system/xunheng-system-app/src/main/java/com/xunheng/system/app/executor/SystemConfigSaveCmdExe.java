
package com.xunheng.system.app.executor;

import com.xunheng.system.app.assembler.CustomConfigAssembler;
import com.xunheng.system.client.dto.SystemConfigSaveCmd;
import com.xunheng.system.client.dto.VO.CustomConfigVO;
import com.xunheng.system.domain.customConfig.gateway.CustomConfigGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 系统拓展配置保存处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:28
 */
@Component
public class SystemConfigSaveCmdExe {
    @Resource
    private CustomConfigGateway customConfigGateway;

    public CustomConfigVO execute(SystemConfigSaveCmd cmd) {
        return CustomConfigAssembler.toVo(customConfigGateway.saveOrUpdate(CustomConfigAssembler.toSystemSaveEntity(cmd)));
    }

}
