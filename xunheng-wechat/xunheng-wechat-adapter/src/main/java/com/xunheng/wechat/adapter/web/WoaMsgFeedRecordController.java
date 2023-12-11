package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.wechat.client.api.WoaMsgFeedRecordService;
import com.xunheng.wechat.client.dto.VO.WoaMsgFeedRecordVO;
import com.xunheng.wechat.client.dto.query.WoaMsgFeedRecordPageQuery;
import com.xunheng.wechat.client.dto.WoaMsgFeedRecordCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgFeedRecordUpdateCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Api("消息推送日志")
@RestController
@RequestMapping("/woaMsgFeedRecord")
public class WoaMsgFeedRecordController {

    @Resource
    WoaMsgFeedRecordService woaMsgFeedRecordService;

    @PermissionCode("wechat.woaMsgFeedRecord.pageList")
    @Log(module = "消息推送日志",title = "消息推送日志分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "消息推送日志分页列表")
    public IPage<WoaMsgFeedRecordVO> getPageList(WoaMsgFeedRecordPageQuery query){
        return woaMsgFeedRecordService.pageList(query);
    }

    @PermissionCode("wechat.woaMsgFeedRecord.detail")
    @Log(module = "消息推送日志",title = "消息推送日志详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "消息推送日志详情")
    public WoaMsgFeedRecordVO getDetail(@PathVariable String id){
        return woaMsgFeedRecordService.getDetail(id);
    }

    @PermissionCode("wechat.woaMsgFeedRecord.add")
    @Log(module = "消息推送日志",title = "消息推送日志新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "消息推送日志新增")
    public WoaMsgFeedRecordVO save(@RequestBody @Validated WoaMsgFeedRecordCreateCmd cmd){
       return woaMsgFeedRecordService.create(cmd);
    }

    @PermissionCode("wechat.woaMsgFeedRecord.edit")
    @Log(module = "消息推送日志",title = "消息推送日志修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "消息推送日志修改")
    public WoaMsgFeedRecordVO edit(@RequestBody @Validated WoaMsgFeedRecordUpdateCmd cmd){
        return woaMsgFeedRecordService.update(cmd);
    }

    @PermissionCode("wechat.woaMsgFeedRecord.deleteBatch")
    @Log(module = "消息推送日志",title = "消息推送日志批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "消息推送日志批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            woaMsgFeedRecordService.remove(id);
        }
         return "删除成功！";
    }
}