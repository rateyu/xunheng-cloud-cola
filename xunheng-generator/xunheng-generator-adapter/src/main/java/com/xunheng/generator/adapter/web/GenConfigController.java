package com.xunheng.generator.adapter.web;

import com.xunheng.base.annotation.RestResponse;
import com.xunheng.generator.client.api.GenConfigService;
import com.xunheng.generator.client.dto.GenConfigSaveAndGenCmd;
import com.xunheng.generator.client.dto.GenConfigSaveCmd;
import com.xunheng.generator.client.dto.VO.FrontCodeVO;
import com.xunheng.generator.client.dto.VO.GenConfigVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;


@Tag(name="代码生成设置")
@RestResponse
@RequestMapping("/genConfig")
public class GenConfigController {

    @Resource
    GenConfigService genConfigService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "代码生成设置保存")
    public String save(@RequestBody GenConfigSaveCmd cmd){
        genConfigService.saveGenConfig(cmd);
        return "添加成功";
    }

    @RequestMapping(value = "/saveAndGen",method = RequestMethod.POST)
    @Operation(summary = "代码生成设置保存并生成")
    public String saveAndGen(@RequestBody GenConfigSaveAndGenCmd cmd){
        genConfigService.saveAndGenConfig(cmd);
        return "生成成功";
    }

    @RequestMapping(value = "/saveAndGenFront",method = RequestMethod.POST)
    @Operation(summary = "前端代码生成设置保存并生成")
    public FrontCodeVO saveAndGenFront(@RequestBody GenConfigSaveAndGenCmd cmd){
        return genConfigService.saveAndGenConfigFront(cmd);
    }

    @RequestMapping(value = "/getConfig",method = RequestMethod.GET)
    @Operation(summary = "获取代码生成设置")
    public GenConfigVO getConfig(){
        return genConfigService.getConfig();
    }

}
