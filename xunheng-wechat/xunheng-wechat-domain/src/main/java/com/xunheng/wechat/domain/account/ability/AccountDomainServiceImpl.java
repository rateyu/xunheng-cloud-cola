package com.xunheng.wechat.domain.account.ability;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.xunheng.wechat.domain.account.gateway.WechatAccountGateway;
import com.xunheng.wechat.domain.account.model.AccountType;
import com.xunheng.wechat.domain.account.model.WechatAccountEntity;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号领域服务实现类
 * @author: hhqkkr
 * @date: 2023/7/25 16:45
 */
@Slf4j
@Component
public class AccountDomainServiceImpl implements AccountDomainService {

    @Resource
    WechatAccountGateway wechatAccountGateway;

    @Resource
    WxMpService wxMpService;

    @Resource
    WxMaService wxMaService;

    @Override
    public boolean isAccountInRuntime(String appId,Boolean officialAccount) {
        try {
            return officialAccount ? wxMpService.switchover(appId) : wxMaService.switchover(appId);
        }catch (NullPointerException e){
            return false;
        }
    }

    @Override
    public void addAccountToRuntime(WechatAccountEntity entity) {
        switch (entity.getType()) {
            case WX_FWH:
            case WX_DYH:
                log.info("更新公众号配置");
                addToMpConfig(entity);
                break;
            case WX_XCX:
                log.info("更新小程序配置");
                addToMaConfig(entity);
                break;
            default:
                break;
        }
    }

    @Override
    public void removeConfig(String id) {
        WechatAccountEntity entity = wechatAccountGateway.getOneById(id);
        log.info("同步移除公众号或小程序配置");
        switch (entity.getType()) {
            case WX_FWH:
            case WX_DYH:
                wxMpService.removeConfigStorage(entity.getAppId());
                break;
            case WX_XCX:
                wxMaService.removeConfig(entity.getAppId());
                break;
            default:
                break;
        }

    }

    @Override
    public void loadWxAccountConfigStorages() {
        log.info("加载公众号与小程序配置...");
        List<WechatAccountEntity> accountList = wechatAccountGateway.allList();
        if (accountList == null || accountList.isEmpty()) {
            log.info("未读取到相关配置，请在管理后台添加");
            return;
        }
        log.info("加载到{}条配置",accountList.size());
        accountList.forEach(this::addAccountToRuntime);
        log.info("公众号与小程序配置加载完成");
    }

    /**
     * 添加账号到当前程序，如首次添加需初始化configStorageMap
     */
    private synchronized void addToMpConfig(WechatAccountEntity entity){
        String appId = entity.getAppId();
        if(isAccountInRuntime(appId,true)) wxMpService.removeConfigStorage(appId);
        WxMpDefaultConfigImpl config = entity.toWxMpConfigStorage();
        try {
            wxMpService.addConfigStorage(appId,config);
        }catch (NullPointerException e){
            log.info("需初始化configStorageMap...");
            Map<String, WxMpConfigStorage> configStorages = new HashMap<>(4);
            configStorages.put(appId,config);
            wxMpService.setMultiConfigStorages(configStorages,appId);
        }
    }


    /**
     * 添加小程序账号到当前程序，如首次添加需初始化configStorageMap
     */
    private synchronized void addToMaConfig(WechatAccountEntity entity){
        String appId = entity.getAppId();
        if(isAccountInRuntime(appId,false)) wxMaService.removeConfig(appId);
        WxMaDefaultConfigImpl config = entity.toWxMaConfigStorage();
        try {
            wxMaService.addConfig(appId,config);
        }catch (NullPointerException e){
            log.info("需初始化configStorageMap...");
            Map<String, WxMaConfig> configStorages = new HashMap<>(4);
            configStorages.put(appId,config);
            wxMaService.setMultiConfigs(configStorages,appId);
        }
    }
}
