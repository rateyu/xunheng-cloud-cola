package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.wechat.client.api.WoaFansService;
import com.xunheng.wechat.client.dto.VO.WoaFansVO;
import com.xunheng.wechat.client.dto.query.WoaFansPageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Api("公众号粉丝")
@RestController
@RequestMapping("/woaFans")
public class WoaFansController {

    @Resource
    WoaFansService woaFansService;

    @PermissionCode("wechat.woaFans.pageList")
    @Log(module = "公众号粉丝",title = "公众号粉丝分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "公众号粉丝分页列表")
    public IPage<WoaFansVO> getPageList(WoaFansPageQuery query){
        return woaFansService.pageList(query);
    }

    @PermissionCode("wechat.woaFans.detail")
    @Log(module = "公众号粉丝",title = "公众号粉丝详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "公众号粉丝详情")
    public WoaFansVO getDetail(@PathVariable String id){
        return woaFansService.getDetail(id);
    }

    @PermissionCode("wechat.woaFans.deleteBatch")
    @Log(module = "公众号粉丝",title = "公众号粉丝批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "公众号粉丝批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            woaFansService.remove(id);
        }
         return "删除成功！";
    }

    @PermissionCode("wechat.woaFans.sync")
    @Log(module = "公众号粉丝",title = "公众号粉丝同步", businessType = BusinessType.OTHER)
    @RequestMapping(value = "/sync/{appId}",method = RequestMethod.GET)
    @ApiOperation(value = "公众号粉丝同步")
    public String sync(@PathVariable String appId){
        woaFansService.syncFans(appId);
        return "同步任务建立成功。";
    }
}