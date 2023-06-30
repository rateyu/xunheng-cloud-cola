package com.xunheng.auth.domain.config.nacos;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.client.naming.event.InstancesChangeEvent;
import com.alibaba.nacos.common.notify.NotifyCenter;
import com.alibaba.nacos.common.notify.listener.Subscriber;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.ServerListUpdater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.util.ProxyUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;

/**
 * @program: xunheng-cloud-cola
 * @description: 服务状态变化监听
 * @author: hhqkkr
 * @date: 2023/6/29 12:57
 */
@Slf4j
@Component
public class InstancesChangeEventListener extends Subscriber<InstancesChangeEvent> implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private MyPollingServerListUpdater myListUpdater;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @PostConstruct
    private void post(){
        NotifyCenter.registerSubscriber(this);
    }


    /**
     * 一旦服务上下线 ribbon同时刷新 保证feign调用时服务的有效性
     */
    @Override
    public void onEvent(InstancesChangeEvent event) {
        String serviceId = event.getServiceName();
        log.info("接收到 InstancesChangeEvent 订阅事件：{}", JSON.toJSONString(event));
        publishEvent();
        RibbonLoadBalancerClient ribbonLoadBalancerClient = (RibbonLoadBalancerClient) loadBalancerClient;
        Method ribbonMethod = ReflectionUtils.findMethod(RibbonLoadBalancerClient.class, "getLoadBalancer", String.class);
        ribbonMethod.setAccessible(true); // 非public方法
        Object ribbonTarget = AopUtils.isAopProxy(ribbonLoadBalancerClient) ? ProxyUtils.getTargetObject(ribbonLoadBalancerClient) : ribbonLoadBalancerClient;
        DynamicServerListLoadBalancer dynamicServerListLoadBalancer = (DynamicServerListLoadBalancer) ReflectionUtils.invokeMethod(ribbonMethod, ribbonTarget, serviceId);
        log.info("begin refresh ribbon, ribbon current service[{}] count {}!", serviceId, dynamicServerListLoadBalancer.getAllServers().size());
        // 也可以调用Ribbon的BaseLoadbalancer.markServerDown方法来清理Ribbon数据
        dynamicServerListLoadBalancer.updateListOfServers();
        log.info("finish refresh ribbon, ribbon current service[{}] count {}!", serviceId, dynamicServerListLoadBalancer.getAllServers().size());

        //通知ribbon更新服务列表
        ServerListUpdater.UpdateAction updateAction = myListUpdater.getUpdateAction();

        if (updateAction != null){
            updateAction.doUpdate();
        }
    }

    /**
     * Type of this subscriber's subscription.
     *
     */
    @Override
    public Class<? extends com.alibaba.nacos.common.notify.Event> subscribeType() {
        return InstancesChangeEvent.class;
    }

    public void publishEvent(){
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(new Object()));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
