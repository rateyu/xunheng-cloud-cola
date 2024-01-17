package com.xunheng.generator.app.executor;

import com.xunheng.generator.app.assembler.GenConfigAssembler;
import com.xunheng.generator.client.dto.GenConfigSaveAndGenCmd;
import com.xunheng.generator.domain.genConfig.ability.GenConfigDomainService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 保存配置表格并生成代码操作处理器
 * @author: hhqkkr
 * @date: 2023/7/3 16:57
 */
@Component
public class GenConfigSaveAndGenCmdExe {

    @Resource
    GenConfigDomainService genConfigDomainService;

    public void execute(GenConfigSaveAndGenCmd cmd){
        genConfigDomainService.saveAndGen(GenConfigAssembler.toSaveAndGenEntity(cmd));
    }
}
