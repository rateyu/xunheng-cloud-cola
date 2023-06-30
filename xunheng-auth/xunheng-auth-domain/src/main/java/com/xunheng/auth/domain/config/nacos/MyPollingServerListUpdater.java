package com.xunheng.auth.domain.config.nacos;

import com.netflix.loadbalancer.PollingServerListUpdater;
import org.springframework.stereotype.Component;

/**
 * @program: xunheng-cloud-cola
 * @description: ribbon服务列表刷新器
 * @author: hhqkkr
 * @date: 2023/6/29 12:59
 */
@Component("ribbonServerListUpdater")
public class MyPollingServerListUpdater extends PollingServerListUpdater {

    private UpdateAction updateAction;

    @Override
    public synchronized void start(UpdateAction updateAction) {
        this.updateAction = updateAction;
        super.start(updateAction);

    }

    public UpdateAction getUpdateAction(){
        return updateAction;
    }
}
