package com.xunheng.generator.app.executor;

import com.xunheng.generator.app.assembler.GenConfigAssembler;
import com.xunheng.generator.client.dto.GenConfigSaveCmd;
import com.xunheng.generator.domain.genConfig.ability.GenConfigDomainService;
import com.xunheng.generator.domain.genConfig.gateway.GenConfigGateway;
import com.xunheng.generator.domain.genConfig.gateway.GenFieldConfigGateway;
import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 保存配置表格操作处理器
 * @author: hhqkkr
 * @date: 2023/7/3 16:57
 */
@Component
public class GenConfigSaveCmdExe {

    @Resource
    GenConfigDomainService genConfigDomainService;

    public void execute(GenConfigSaveCmd cmd){
        GenConfigEntity saveEntity = GenConfigAssembler.toSaveEntity(cmd);
        genConfigDomainService.save(saveEntity);
    }
}
