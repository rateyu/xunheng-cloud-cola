
package com.xunheng.system.app.executor;

import com.xunheng.system.domain.dict.gateway.DictDataGateway;
import com.xunheng.system.domain.dict.gateway.DictGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典删除处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:07
 */
@Component
public class DictRemoveCmdExe {

    @Resource
    private DictGateway dictGateway;

    @Resource
    private DictDataGateway dictDataGateway;

    public void execute(String id) {
        /*删除字典下的数据*/
        dictDataGateway.removeByDictId(id);
        /*删除字典*/
        dictGateway.remove(id);
    }

}
