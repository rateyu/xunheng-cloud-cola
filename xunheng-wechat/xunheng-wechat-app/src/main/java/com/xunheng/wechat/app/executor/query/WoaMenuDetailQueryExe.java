package com.xunheng.wechat.app.executor.query;

import com.xunheng.base.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 获取微信公众号菜单查询处理器
 * @author: hhqkkr
 * @date: 2023/7/28 17:09
 */
@Slf4j
@Component
public class WoaMenuDetailQueryExe {

    @Resource
    WxMpService wxMpService;

    public WxMpMenu execute(String appId){
        if(appId == null)return null;
        try {
            wxMpService.switchoverTo(appId);
            return wxMpService.getMenuService().menuGet();
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new GlobalException("获取菜单失败！");
        }
    }
}
