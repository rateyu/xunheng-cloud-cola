package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.wechat.client.api.WechatAccountService;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.client.dto.VO.WxAccountSelectItemVO;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import com.xunheng.wechat.client.dto.WechatAccountCreateCmd;
import com.xunheng.wechat.client.dto.WechatAccountUpdateCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@Api("微信开发帐号")
@RestController
@RequestMapping("/wechatAccount")
public class WechatAccountController {

    @Resource
    WechatAccountService wechatAccountService;

    @PermissionCode("wechat.wechatAccount.pageList")
    @Log(module = "微信开发帐号",title = "微信开发帐号分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "微信开发帐号分页列表")
    public IPage<WechatAccountVO> getPageList(WechatAccountPageQuery query){
        return wechatAccountService.pageList(query);
    }

    @PermissionCode("wechat.wechatAccount.detail")
    @Log(module = "微信开发帐号",title = "微信开发帐号详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "微信开发帐号详情")
    public WechatAccountVO getDetail(@PathVariable String id){
        return wechatAccountService.getDetail(id);
    }

    @PermissionCode("wechat.wechatAccount.add")
    @Log(module = "微信开发帐号",title = "微信开发帐号新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "微信开发帐号新增")
    public WechatAccountVO save(@RequestBody @Validated WechatAccountCreateCmd cmd){
       return wechatAccountService.create(cmd);
    }

    @PermissionCode("wechat.wechatAccount.edit")
    @Log(module = "微信开发帐号",title = "微信开发帐号修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "微信开发帐号修改")
    public WechatAccountVO edit(@RequestBody @Validated WechatAccountUpdateCmd cmd){
        return wechatAccountService.update(cmd);
    }

    @PermissionCode("wechat.wechatAccount.deleteBatch")
    @Log(module = "微信开发帐号",title = "微信开发帐号批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "微信开发帐号批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            wechatAccountService.remove(id);
        }
         return "删除成功！";
    }

    @Log(module = "微信开发帐号",title = "微信开发帐号选择项", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getSelectItem",method = RequestMethod.GET)
    @ApiOperation(value = "微信开发帐号选择项")
    public List<WxAccountSelectItemVO> getSelectItem(){
        return wechatAccountService.getSelectItem();
    }
}