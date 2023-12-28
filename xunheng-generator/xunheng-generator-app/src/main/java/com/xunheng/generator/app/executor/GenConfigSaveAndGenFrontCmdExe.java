package com.xunheng.generator.app.executor;

import com.xunheng.generator.app.assembler.GenConfigAssembler;
import com.xunheng.generator.client.dto.GenConfigSaveAndGenCmd;
import com.xunheng.generator.client.dto.VO.FrontCodeVO;
import com.xunheng.generator.domain.genConfig.ability.GenConfigDomainService;
import com.xunheng.generator.domain.genConfig.model.FrontCodeEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 保存配置表格并前端生成代码操作处理器
 * @author: hhqkkr
 * @date: 2023/7/3 16:57
 */
@Component
public class GenConfigSaveAndGenFrontCmdExe {

    @Resource
    GenConfigDomainService genConfigDomainService;

    public FrontCodeVO execute(GenConfigSaveAndGenCmd cmd){
        FrontCodeEntity entity = genConfigDomainService.saveAndGenFront(GenConfigAssembler.toSaveAndGenEntity(cmd));
        return new FrontCodeVO(entity.getCodeApi(), entity.getCodeSave(), entity.getCodeIndex());
    }
}
