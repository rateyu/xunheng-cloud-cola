package com.xunheng.wechat.client.api;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号菜单Service
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
public interface WoaMenuService {

    /**
     * 获取公众号菜单
     * @param appId appId
     * @return 公众号菜单对象
     */
    WxMpMenu getMenu(String appId);

    /**
     * 保存并发布菜单
     * @param appId appId
     */
    void saveAndDeploy(String appId, WxMenu wxMenu);
}