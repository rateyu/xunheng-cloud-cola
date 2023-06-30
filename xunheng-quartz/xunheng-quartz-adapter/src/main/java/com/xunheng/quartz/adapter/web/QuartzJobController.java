package com.xunheng.quartz.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.quartz.client.api.QuartzJobService;
import com.xunheng.quartz.client.dto.QuartzJobCreateCmd;
import com.xunheng.quartz.client.dto.QuartzJobUpdateCmd;
import com.xunheng.quartz.client.dto.VO.QuartzJobVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api("定时任务")
@RestController
@RequestMapping("/quartz")
public class QuartzJobController {

    @Resource
    private QuartzJobService quartzJobService;

    @PermissionCode("system.quartz.allList")
    @Log(module = "定时任务",title = "定时任务所有列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ApiOperation(value = "定时任务所有列表")
    public List<QuartzJobVO> getAll(){
        return quartzJobService.getAll();
    }

    @PermissionCode("system.quartz.add")
    @Log(module = "定时任务",title = "定时任务新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "定时任务新增")
    public String addJob(@RequestBody @Validated QuartzJobCreateCmd cmd){
        quartzJobService.create(cmd);
        return "创建定时任务成功";
    }

    @PermissionCode("system.quartz.pause")
    @Log(module = "定时任务",title = "定时任务暂停", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/pause/{id}",method = RequestMethod.POST)
    @ApiOperation(value = "定时任务暂停")
    public String pauseJob(@PathVariable String id){
        quartzJobService.pause(id);
        return "暂停定时任务成功";
    }

    @PermissionCode("system.quartz.resume")
    @Log(module = "定时任务",title = "定时任务恢复", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/resume/{id}",method = RequestMethod.POST)
    @ApiOperation(value = "定时任务恢复")
    public String resumeJob(@PathVariable String id){
        quartzJobService.resume(id);
        return "恢复定时任务成功";
    }

    @PermissionCode("system.quartz.edit")
    @Log(module = "定时任务",title = "定时任务修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "定时任务修改")
    public String edit(@RequestBody @Validated QuartzJobUpdateCmd cmd){
        quartzJobService.update(cmd);
        return "更新定时任务成功";
    }

    @PermissionCode("system.quartz.delete")
    @Log(module = "定时任务",title = "定时任务删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "定时任务删除")
    public String remove(@PathVariable String id){
        quartzJobService.remove(id);
        return "删除定时任务成功";
    }

    @PermissionCode("system.quartz.execute")
    @Log(module = "定时任务",title = "定时任务执行一次", businessType = BusinessType.OTHER)
    @RequestMapping(value = "/execute/{id}",method = RequestMethod.POST)
    @ApiOperation(value = "定时任务执行一次")
    public String execute(@PathVariable String id){
        quartzJobService.executeOnce(id);
        return "执行一次定时任务成功";
    }

}
