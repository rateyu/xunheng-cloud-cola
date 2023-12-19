package com.xunheng.wechat.app.executor;

import com.xunheng.base.exception.GlobalException;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号菜单保存并发布操作处理器
 * @author: hhqkkr
 * @date: 2023/7/28 17:10
 */
@Component
public class WoaMenuSaveCmdExe {

    @Resource
    WxMpService wxMpService;

    public void execute(String appId, WxMenu wxMenu){
        try {
            wxMpService.switchoverTo(appId);
            wxMpService.getMenuService().menuCreate(wxMenu);
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new GlobalException("保存菜单失败！");
        }
    }
}
