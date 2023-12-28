
package com.xunheng.system.app.executor;

import com.xunheng.system.domain.dict.gateway.DictDataGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据删除处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:06
 */
@Component
public class DictDataRemoveCmdExe {
    @Resource
    private DictDataGateway dictDataGateway;

    public void execute(String id) {
        dictDataGateway.remove(id);
    }

}
