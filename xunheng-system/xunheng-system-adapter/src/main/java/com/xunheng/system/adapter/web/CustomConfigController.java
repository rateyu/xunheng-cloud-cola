package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.CustomConfigService;
import com.xunheng.system.client.dto.SystemConfigSaveCmd;
import com.xunheng.system.client.dto.PersonalConfigSaveCmd;
import com.xunheng.system.client.dto.VO.CustomConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api("自定义设置")
@RestController
@RequestMapping("/customConfig")
public class CustomConfigController {

    @Resource
    CustomConfigService customConfigService;

    @PermissionCode("none")
    @Log(module = "自定义设置",title = "保存个性化设置", businessType = BusinessType.ADD)
    @RequestMapping(value = "/savePersonalConfig",method = RequestMethod.POST)
    @ApiOperation(value = "保存个性化设置")
    public CustomConfigVO savePersonalConfig(@RequestBody @Validated PersonalConfigSaveCmd cmd){
        return customConfigService.savePersonalConfig(cmd);
    }

    @PermissionCode("none")
    @Log(module = "自定义设置",title = "保存系统拓展设置", businessType = BusinessType.ADD)
    @RequestMapping(value = "/saveExtendConfig",method = RequestMethod.POST)
    @ApiOperation(value = "保存系统拓展设置")
    public CustomConfigVO saveSystemConfig(@RequestBody @Validated SystemConfigSaveCmd cmd){
        return customConfigService.saveSystemConfig(cmd);
    }

    @PermissionCode("none")
    @Log(module = "自定义设置",title = "获取系统拓展配置", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getExtendConfigList",method = RequestMethod.GET)
    @ApiOperation(value = "获取系统拓展配置")
    public List<CustomConfigVO> getSystemConfigList(){
        return customConfigService.getSystemConfigList();
    }

    @PermissionCode("none")
    @Log(module = "自定义设置",title = "自定义设置批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "自定义设置批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            customConfigService.remove(id);
        }
        return "删除成功";
    }

}
