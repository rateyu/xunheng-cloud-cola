package com.xunheng.system.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.NoticeService;
import com.xunheng.system.client.dto.query.NoticePageQuery;
import com.xunheng.system.client.dto.VO.NoticeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api("系统信息")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    NoticeService noticeService;

    @PermissionCode("none")
    @Log(module = "系统信息",title = "未读系统信息列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getUnReadNoticeList",method = RequestMethod.GET)
    @ApiOperation(value = "未读系统信息列表")
    public List<NoticeVO> getUnReadNoticeList(){
        return noticeService.getUnReadNoticeList();
    }

    @PermissionCode("none")
    @Log(module = "系统信息",title = "系统信息分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "系统信息分页列表")
    public IPage<NoticeVO> getPageList(NoticePageQuery query){
        return noticeService.pageList(query);
    }

    @PermissionCode("none")
    @Log(module = "系统信息",title = "标记已读", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/markRead/{id}",method = RequestMethod.POST)
    @ApiOperation(value = "标记已读")
    public String markRead(@PathVariable String id){
        noticeService.markRead(id);
        return "操作成功";
    }

    @PermissionCode("none")
    @Log(module = "系统信息",title = "标记所有已读", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/markReadAll",method = RequestMethod.POST)
    @ApiOperation(value = "标记所有已读")
    public String markReadAll(){
        noticeService.markReadAll();
        return "操作成功";
    }

    @PermissionCode("none")
    @Log(module = "系统信息",title = "系统信息批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "系统信息批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            noticeService.remove(id);
        }
        return "删除成功";
    }
}
