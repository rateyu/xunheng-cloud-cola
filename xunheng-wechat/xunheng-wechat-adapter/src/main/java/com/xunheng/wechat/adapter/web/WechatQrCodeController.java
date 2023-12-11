package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.wechat.client.api.WechatQrCodeService;
import com.xunheng.wechat.client.dto.VO.WechatQrCodeVO;
import com.xunheng.wechat.client.dto.query.WechatQrCodePageQuery;
import com.xunheng.wechat.client.dto.WechatQrCodeCreateCmd;
import com.xunheng.wechat.client.dto.WechatQrCodeUpdateCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Api("账号二维码信息")
@RestController
@RequestMapping("/wechatQrCode")
public class WechatQrCodeController {

    @Resource
    WechatQrCodeService wechatQrCodeService;

    @PermissionCode("wechat.wechatQrCode.pageList")
    @Log(module = "账号二维码信息",title = "账号二维码信息分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "账号二维码信息分页列表")
    public IPage<WechatQrCodeVO> getPageList(WechatQrCodePageQuery query){
        return wechatQrCodeService.pageList(query);
    }

    @PermissionCode("wechat.wechatQrCode.detail")
    @Log(module = "账号二维码信息",title = "账号二维码信息详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "账号二维码信息详情")
    public WechatQrCodeVO getDetail(@PathVariable String id){
        return wechatQrCodeService.getDetail(id);
    }

    @PermissionCode("wechat.wechatQrCode.add")
    @Log(module = "账号二维码信息",title = "账号二维码信息新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "账号二维码信息新增")
    public WechatQrCodeVO save(@RequestBody @Validated WechatQrCodeCreateCmd cmd){
       return wechatQrCodeService.create(cmd);
    }

    @PermissionCode("wechat.wechatQrCode.edit")
    @Log(module = "账号二维码信息",title = "账号二维码信息修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "账号二维码信息修改")
    public WechatQrCodeVO edit(@RequestBody @Validated WechatQrCodeUpdateCmd cmd){
        return wechatQrCodeService.update(cmd);
    }

    @PermissionCode("wechat.wechatQrCode.deleteBatch")
    @Log(module = "账号二维码信息",title = "账号二维码信息批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "账号二维码信息批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            wechatQrCodeService.remove(id);
        }
         return "删除成功！";
    }
}