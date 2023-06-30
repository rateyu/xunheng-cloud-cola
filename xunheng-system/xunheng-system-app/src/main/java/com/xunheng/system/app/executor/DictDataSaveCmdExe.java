
package com.xunheng.system.app.executor;

import com.xunheng.system.app.assembler.DictDataAssembler;
import com.xunheng.system.domain.dict.model.DictDataEntity;
import com.xunheng.system.client.dto.DictDataSaveCmd;
import com.xunheng.system.client.dto.VO.DictDataVO;
import com.xunheng.system.domain.dict.gateway.DictDataGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据保存处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:07
 */
@Component
public class DictDataSaveCmdExe {

    @Resource
    private DictDataGateway dictDataGateway;

    public DictDataVO execute(DictDataSaveCmd cmd) {
        DictDataEntity saveEntity = DictDataAssembler.toSaveEntity(cmd);
        return DictDataAssembler.toVo(dictDataGateway.saveOrUpdate(saveEntity));
    }

}
