package com.xunheng.log.adapter.web;

import com.xunheng.base.annotation.FeignAPI;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.log.client.api.SysLogService;
import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.log.client.dto.VO.LogVO;
import com.xunheng.log.client.dto.query.LogPageQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.Map;

@Tag(name="系统日志")
@RestResponse
@RequestMapping("/sysLog")
public class SysLogController {

    @Resource
    SysLogService sysLogService;

    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "系统日志分页列表")
    public Page<LogVO> getPageList(LogPageQuery query){
        return sysLogService.pageList(query);
    }

    @RequestMapping(value = "/getEchartsData",method = RequestMethod.GET)
    @Operation(summary = "系统日志echarts数据")
    public Map<String, Object> getEchartsData(){
        return sysLogService.getEchartsData();
    }

    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "系统日志批量删除")
    public String remove(@PathVariable String[] ids){
        for (String id : ids) {
            sysLogService.remove(id);
        }
        return "批量通过id删除数据成功";
    }

    @RequestMapping(value = "/clean",method = RequestMethod.DELETE)
    @Operation(summary = "系统日志清空")
    public String clean(){
        sysLogService.removeAll();
        return "系统日志清空成功";
    }

    @FeignAPI
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "保存数据")
    public LogVO save(@RequestBody LogCreateCmd cmd){
        return sysLogService.save(cmd);
    }

}
