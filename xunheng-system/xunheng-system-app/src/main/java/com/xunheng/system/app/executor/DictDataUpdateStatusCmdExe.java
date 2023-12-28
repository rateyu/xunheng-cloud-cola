
package com.xunheng.system.app.executor;

import com.xunheng.system.domain.dict.gateway.DictDataGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据状态更新处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:07
 */
@Component
public class DictDataUpdateStatusCmdExe {
    @Resource
    private DictDataGateway dictDataGateway;

    public void execute(String id, Integer status) {
        dictDataGateway.updateStatus(id,status);
    }

}
