package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.wechat.client.api.WoaMsgTemplateService;
import com.xunheng.wechat.client.dto.VO.WoaMsgTemplateVO;
import com.xunheng.wechat.client.dto.query.WoaMsgTemplatePageQuery;
import com.xunheng.wechat.client.dto.WoaMsgTemplateCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgTemplateUpdateCmd;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

@Tag(name="消息推送模板")
@RestResponse
@RequestMapping("/woaMsgTemplate")
public class WoaMsgTemplateController {

    @Resource
    WoaMsgTemplateService woaMsgTemplateService;

    @PermissionCode("wechat.woaMsgTemplate.pageList")
    @Log(module = "消息推送模板",title = "消息推送模板分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "消息推送模板分页列表")
    public IPage<WoaMsgTemplateVO> getPageList(WoaMsgTemplatePageQuery query){
        return woaMsgTemplateService.pageList(query);
    }

    @PermissionCode("wechat.woaMsgTemplate.detail")
    @Log(module = "消息推送模板",title = "消息推送模板详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @Operation(summary = "消息推送模板详情")
    public WoaMsgTemplateVO getDetail(@PathVariable String id){
        return woaMsgTemplateService.getDetail(id);
    }

    @PermissionCode("wechat.woaMsgTemplate.add")
    @Log(module = "消息推送模板",title = "消息推送模板新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "消息推送模板新增")
    public WoaMsgTemplateVO save(@RequestBody @Validated WoaMsgTemplateCreateCmd cmd){
       return woaMsgTemplateService.create(cmd);
    }

    @PermissionCode("wechat.woaMsgTemplate.edit")
    @Log(module = "消息推送模板",title = "消息推送模板修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "消息推送模板修改")
    public WoaMsgTemplateVO edit(@RequestBody @Validated WoaMsgTemplateUpdateCmd cmd){
        return woaMsgTemplateService.update(cmd);
    }

    @PermissionCode("wechat.woaMsgTemplate.deleteBatch")
    @Log(module = "消息推送模板",title = "消息推送模板批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "消息推送模板批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            woaMsgTemplateService.remove(id);
        }
         return "删除成功！";
    }

    @PermissionCode("wechat.woaMsgTemplate.sync")
    @Log(module = "消息推送模板",title = "消息推送模板同步", businessType = BusinessType.OTHER)
    @RequestMapping(value = "/sync/{appId}",method = RequestMethod.GET)
    @Operation(summary = "消息推送模板同步")
    public String sync(@PathVariable String appId){
        woaMsgTemplateService.sync(appId);
        return "同步成功。";
    }
}