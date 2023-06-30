
package com.xunheng.system.app.executor;

import com.xunheng.system.domain.customConfig.gateway.CustomConfigGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @program: xunheng-cloud-cola
 * @description: 个性化配置删除处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:06
 */
@Component
public class CustomConfigRemoveCmdExe {

    @Resource
    private CustomConfigGateway customConfigGateway;

    public void execute(String id) {
        customConfigGateway.remove(id);
    }

}
