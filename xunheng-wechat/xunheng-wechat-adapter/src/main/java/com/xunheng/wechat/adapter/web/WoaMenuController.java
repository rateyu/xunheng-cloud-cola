package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.ResponseNotIntercept;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.wechat.client.api.WoaMenuService;
import com.xunheng.wechat.client.api.WoaMsgService;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.client.dto.WoaAuthCheckCmd;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

@Tag(name="公众号菜单")
@RestResponse
@RequestMapping("/woaMenu")
public class WoaMenuController {

    @Resource
    WoaMenuService woaMenuService;

    @PermissionCode("wechat.woaMenu.detail")
    @Log(module = "微信公众号菜单",title = "微信公众号菜单获取", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getMenu/{appId}",method = RequestMethod.GET)
    @Operation(summary = "微信公众号菜单获取")
    public WxMpMenu getMenu(@PathVariable String appId){
        return woaMenuService.getMenu(appId);
    }

    @PermissionCode("wechat.woaMenu.save")
    @Log(module = "微信公众号菜单",title = "微信公众号菜单保存", businessType = BusinessType.ADD)
    @RequestMapping(value = "/saveAndDeploy/{appId}",method = RequestMethod.POST)
    @Operation(summary = "微信公众号菜单保存")
    public String save(@PathVariable String appId,@RequestBody WxMenu wxMenu){
        woaMenuService.saveAndDeploy(appId,wxMenu);
        return "保存成功！";
    }

}