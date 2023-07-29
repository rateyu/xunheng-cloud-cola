package com.xunheng.wechat.domain.wechatAccount.ability;

import com.xunheng.wechat.domain.wechatAccount.model.WechatAccountEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号领域服务
 * @author: hhqkkr
 * @date: 2023/7/25 16:40
 */
public interface WechatAccountDomainService {

    /**
     * 判断当前帐号是否已经放进配置
     * @param appId appId
     * @return 是/否
     */
    boolean isAccountInRuntime(String appId);

    /**
     * 将账户信息添加进配置
     * @param entity 账户信息
     */
     void addAccountToRuntime(WechatAccountEntity entity);

    /**
     * 删除配置
     * @param id id
     */
     void removeConfig(String id);

    /**
     * 加载当前存在的帐号添加进配置
     */
    void loadWxMpConfigStorages();


}
