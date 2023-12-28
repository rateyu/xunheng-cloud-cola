
package com.xunheng.system.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.system.app.assembler.DictAssembler;
import com.xunheng.system.client.dto.DictSaveCmd;
import com.xunheng.system.client.dto.VO.DictVO;
import com.xunheng.system.domain.dict.gateway.DictGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典信息保存处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:08
 */
@Component
public class DictSaveCmdExe {

    @Resource
    private DictGateway dictGateway;

    public DictVO execute(DictSaveCmd cmd) {
        //判断type是否已经存在
        if(dictGateway.checkExist(cmd.getType(),cmd.getId()))throw new GlobalException("字典类型Type已存在");
        return DictAssembler.toVo(dictGateway.saveOrUpdate(DictAssembler.toSaveEntity(cmd)));
    }

}
