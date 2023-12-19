package com.xunheng.wechat.app;

import com.xunheng.wechat.app.executor.WoaMenuSaveCmdExe;
import com.xunheng.wechat.app.executor.query.WoaMenuDetailQueryExe;
import com.xunheng.wechat.client.api.WoaMenuService;
import io.seata.spring.annotation.GlobalTransactional;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号菜单Service实现类
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Service
@GlobalTransactional
public class WoaMenuServiceImpl implements WoaMenuService {

    @Resource
    WoaMenuDetailQueryExe woaMenuDetailQueryExe;

    @Resource
    WoaMenuSaveCmdExe woaMenuSaveCmdExe;

    @Override
    public WxMpMenu getMenu(String appId) {
        return woaMenuDetailQueryExe.execute(appId);
    }

    @Override
    public void saveAndDeploy(String appId, WxMenu wxMenu) {
         woaMenuSaveCmdExe.execute(appId,wxMenu);
    }
}