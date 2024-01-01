package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.wechat.client.api.WechatUserService;
import com.xunheng.wechat.client.dto.VO.WechatUserVO;
import com.xunheng.wechat.client.dto.query.WechatUserPageQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

@Tag(name="微信用户")
@RestResponse
@RequestMapping("/wechatUser")
public class WechatUserController {

    @Resource
    WechatUserService wechatUserService;

    @PermissionCode("wechat.wechatUser.pageList")
    @Log(module = "微信用户",title = "微信用户分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "微信用户分页列表")
    public IPage<WechatUserVO> getPageList(WechatUserPageQuery query){
        return wechatUserService.pageList(query);
    }

    @PermissionCode("wechat.wechatUser.detail")
    @Log(module = "微信用户",title = "微信用户详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @Operation(summary = "微信用户详情")
    public WechatUserVO getDetail(@PathVariable String id){
        return wechatUserService.getDetail(id);
    }

    @PermissionCode("wechat.wechatUser.deleteBatch")
    @Log(module = "微信用户",title = "微信用户批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "微信用户批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            wechatUserService.remove(id);
        }
         return "删除成功！";
    }

    @PermissionCode("wechat.wechatUser.sync")
    @Log(module = "微信用户",title = "微信用户同步", businessType = BusinessType.OTHER)
    @RequestMapping(value = "/sync/{appId}",method = RequestMethod.GET)
    @Operation(summary = "微信用户同步")
    public String sync(@PathVariable String appId){
        wechatUserService.syncFans(appId);
        return "同步任务建立成功。";
    }
}