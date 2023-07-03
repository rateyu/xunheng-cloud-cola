package com.xunheng.generator.adapter.web;

import com.xunheng.generator.client.api.GenConfigService;
import com.xunheng.generator.client.dto.GenConfigSaveAndGenCmd;
import com.xunheng.generator.client.dto.GenConfigSaveCmd;
import com.xunheng.generator.client.dto.VO.GenConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api("代码生成设置")
@RestController
@RequestMapping("/genConfig")
public class GenConfigController {

    @Resource
    GenConfigService genConfigService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "代码生成设置保存")
    public String save(@RequestBody GenConfigSaveCmd cmd){
        genConfigService.saveGenConfig(cmd);
        return "添加成功";
    }

    @RequestMapping(value = "/saveAndGen",method = RequestMethod.POST)
    @ApiOperation(value = "代码生成设置保存并生成")
    public String saveAndGen(@RequestBody GenConfigSaveAndGenCmd cmd){
        genConfigService.saveAndGenConfig(cmd);
        return "生成成功";
    }

    @RequestMapping(value = "/getConfig",method = RequestMethod.GET)
    @ApiOperation(value = "获取代码生成设置")
    public GenConfigVO getConfig(){
        return genConfigService.getConfig();
    }

}
