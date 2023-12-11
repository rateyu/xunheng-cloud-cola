package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.wechat.client.api.WoaReplyRuleService;
import com.xunheng.wechat.client.dto.VO.WoaReplyRuleVO;
import com.xunheng.wechat.client.dto.query.WoaReplyRulePageQuery;
import com.xunheng.wechat.client.dto.WoaReplyRuleCreateCmd;
import com.xunheng.wechat.client.dto.WoaReplyRuleUpdateCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Api("公众号回复规则")
@RestController
@RequestMapping("/woaReplyRule")
public class WoaReplyRuleController {

    @Resource
    WoaReplyRuleService woaReplyRuleService;

    @PermissionCode("wechat.woaReplyRule.pageList")
    @Log(module = "公众号回复规则",title = "公众号回复规则分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "公众号回复规则分页列表")
    public IPage<WoaReplyRuleVO> getPageList(WoaReplyRulePageQuery query){
        return woaReplyRuleService.pageList(query);
    }

    @PermissionCode("wechat.woaReplyRule.detail")
    @Log(module = "公众号回复规则",title = "公众号回复规则详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "公众号回复规则详情")
    public WoaReplyRuleVO getDetail(@PathVariable String id){
        return woaReplyRuleService.getDetail(id);
    }

    @PermissionCode("wechat.woaReplyRule.add")
    @Log(module = "公众号回复规则",title = "公众号回复规则新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "公众号回复规则新增")
    public WoaReplyRuleVO save(@RequestBody @Validated WoaReplyRuleCreateCmd cmd){
       return woaReplyRuleService.create(cmd);
    }

    @PermissionCode("wechat.woaReplyRule.edit")
    @Log(module = "公众号回复规则",title = "公众号回复规则修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "公众号回复规则修改")
    public WoaReplyRuleVO edit(@RequestBody @Validated WoaReplyRuleUpdateCmd cmd){
        return woaReplyRuleService.update(cmd);
    }

    @PermissionCode("wechat.woaReplyRule.deleteBatch")
    @Log(module = "公众号回复规则",title = "公众号回复规则批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "公众号回复规则批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            woaReplyRuleService.remove(id);
        }
         return "删除成功！";
    }
}