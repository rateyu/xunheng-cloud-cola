package com.xunheng.wechat.domain.wechatAccount.ability;

import com.xunheng.wechat.domain.wechatAccount.gateway.WechatAccountGateway;
import com.xunheng.wechat.domain.wechatAccount.model.AccountType;
import com.xunheng.wechat.domain.wechatAccount.model.WechatAccountEntity;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
public class WechatAccountDomainServiceImpl implements WechatAccountDomainService {

    @Resource
    WechatAccountGateway wechatAccountGateway;

    @Resource
    WxMpService wxMpService;

    @Override
    public boolean isAccountInRuntime(String appId) {
        try {
            return wxMpService.switchover(appId);
        }catch (NullPointerException e){
            return false;
        }
    }

    @Override
    public void addAccountToRuntime(WechatAccountEntity entity) {
        /*只处理类型是公众号的*/
        if(!entity.getType().equals(AccountType.WOA_FWH) && !entity.getType().equals(AccountType.WOA_DYH))return;
        String appid = entity.getAppId();
        if(isAccountInRuntime(appid)){//已有此appid信息，更新
            log.info("更新公众号配置");
            wxMpService.removeConfigStorage(appid);
            addToConfig(entity);
        }else {//无此appid信息，新增
            log.info("新增公众号配置");
            addToConfig(entity);
        }
    }

    @Override
    public void removeConfig(String id) {
        WechatAccountEntity entity = wechatAccountGateway.getOneById(id);
        // 更新wxMpService配置
        log.info("同步移除公众号配置");
        wxMpService.removeConfigStorage(entity.getAppId());
    }

    @Override
    public void loadWxMpConfigStorages() {
        log.info("加载公众号配置...");
        List<WechatAccountEntity> accountList = wechatAccountGateway.allList();
        if (accountList == null || accountList.isEmpty()) {
            log.info("未读取到公众号配置，请在管理后台添加");
            return;
        }
        log.info("加载到{}条公众号配置",accountList.size());
        accountList.forEach(this::addAccountToRuntime);
        log.info("公众号配置加载完成");
    }

    /**
     * 添加账号到当前程序，如首次添加需初始化configStorageMap
     */
    private synchronized void addToConfig(WechatAccountEntity entity){
        String appid = entity.getAppId();
        WxMpDefaultConfigImpl config = entity.toWxMpConfigStorage();
        try {
            wxMpService.addConfigStorage(appid,config);
        }catch (NullPointerException e){
            log.info("需初始化configStorageMap...");
            Map<String, WxMpConfigStorage> configStorages = new HashMap<>(4);
            configStorages.put(appid,config);
            wxMpService.setMultiConfigStorages(configStorages,appid);
        }
    }
}
