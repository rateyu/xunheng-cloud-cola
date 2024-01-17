package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.DictService;
import com.xunheng.system.client.dto.DictSaveCmd;
import com.xunheng.system.client.dto.VO.DictVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name="字典")
@RestResponse
@RequestMapping("/dict")
public class DictController {

    @Resource
    DictService dictService;

    @PermissionCode("system.dict.allList")
    @Log(module = "字典",title = "字典分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @Operation(summary = "字典全部列表")
    public List<DictVO> getAll(){
        return dictService.getAll();
    }

    @PermissionCode("system.dict.add")
    @Log(module = "字典",title = "字典新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @Operation(summary = "字典新增")
    public DictVO add(@RequestBody @Validated DictSaveCmd cmd){
        return dictService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.dict.edit")
    @Log(module = "字典",title = "字典编辑", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "字典编辑")
    public DictVO edit(@RequestBody @Validated DictSaveCmd cmd){
        return dictService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.dict.delete")
    @Log(module = "字典",title = "字典删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{id}",method = RequestMethod.DELETE)
    @Operation(summary = "字典删除")
    public String remove(@PathVariable String id){
        dictService.remove(id);
        return "删除成功";
    }

}
