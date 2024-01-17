package com.xunheng.quartz.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.quartz.client.api.QuartzJobLogService;
import com.xunheng.quartz.client.dto.VO.QuartzJobLogVO;
import com.xunheng.quartz.client.dto.query.QuartzJobLogPageQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

@Tag(name="定时任务日志")
@RestResponse
@RequestMapping("/quartzLog")
public class QuartzJobLogController {

    @Resource
    private QuartzJobLogService quartzJobLogService;


    @PermissionCode("system.quartzLog.pageList")
    @Log(module = "定时任务日志",title = "定时任务日志分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "定时任务日志分页列表")
    public IPage<QuartzJobLogVO> getPageList(QuartzJobLogPageQuery query){
        return quartzJobLogService.pageList(query);
    }

}
