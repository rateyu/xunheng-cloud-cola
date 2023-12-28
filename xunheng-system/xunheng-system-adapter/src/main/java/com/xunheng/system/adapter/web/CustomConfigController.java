package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.system.client.api.CustomConfigService;
import com.xunheng.system.client.dto.SystemConfigSaveCmd;
import com.xunheng.system.client.dto.PersonalConfigSaveCmd;
import com.xunheng.system.client.dto.VO.CustomConfigVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name="自定义设置")
@RestResponse
@RequestMapping("/customConfig")
public class CustomConfigController {

    @Resource
    CustomConfigService customConfigService;

    @PermissionCode("none")
    @Log(module = "自定义设置",title = "保存个性化设置", businessType = BusinessType.ADD)
    @RequestMapping(value = "/savePersonalConfig",method = RequestMethod.POST)
    @Operation(summary = "保存个性化设置")
    public CustomConfigVO savePersonalConfig(@RequestBody @Validated PersonalConfigSaveCmd cmd){
        return customConfigService.savePersonalConfig(cmd);
    }

    @PermissionCode("none")
    @Log(module = "自定义设置",title = "保存系统拓展设置", businessType = BusinessType.ADD)
    @RequestMapping(value = "/saveExtendConfig",method = RequestMethod.POST)
    @Operation(summary = "保存系统拓展设置")
    public CustomConfigVO saveSystemConfig(@RequestBody @Validated SystemConfigSaveCmd cmd){
        return customConfigService.saveSystemConfig(cmd);
    }

    @PermissionCode("none")
    @Log(module = "自定义设置",title = "获取系统拓展配置", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getExtendConfigList",method = RequestMethod.GET)
    @Operation(summary = "获取系统拓展配置")
    public List<CustomConfigVO> getSystemConfigList(){
        return customConfigService.getSystemConfigList();
    }

    @PermissionCode("none")
    @Log(module = "自定义设置",title = "自定义设置批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "自定义设置批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            customConfigService.remove(id);
        }
        return "删除成功";
    }

}
