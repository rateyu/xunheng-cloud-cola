package com.xunheng.auth.domain.config.nacos;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.client.config.impl.ServerlistChangeEvent;
import com.alibaba.nacos.common.notify.NotifyCenter;
import com.alibaba.nacos.common.notify.listener.Subscriber;
import com.netflix.loadbalancer.ServerListUpdater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: xunheng-cloud-cola
 * @description: 服务状态变化监听
 * @author: hhqkkr
 * @date: 2023/6/29 12:57
 */
@Slf4j
@Component
public class ServerListChangeEventListener extends Subscriber<ServerlistChangeEvent> implements ApplicationEventPublisherAware {


    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private MyPollingServerListUpdater myListUpdater;

    @PostConstruct
    private void post(){
        NotifyCenter.registerSubscriber(this);
    }


    /**
     * Event callback.
     *
     * @param event {@link Event}
     */
    @Override
    public void onEvent(ServerlistChangeEvent event) {
        log.info("接收到 ServerListChangeEvent 订阅事件：{}", JSON.toJSONString(event));
        publishEvent();
        //通知ribbon更新服务列表
        ServerListUpdater.UpdateAction updateAction = myListUpdater.getUpdateAction();

        if (updateAction != null){
            updateAction.doUpdate();
        }
    }

    /**
     * Type of this subscriber's subscription.
     *
     * @return Class which extends {@link Event}
     */
    @Override
    public Class<? extends com.alibaba.nacos.common.notify.Event> subscribeType() {
        return ServerlistChangeEvent.class;
    }

    public void publishEvent(){
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(new Object()));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
