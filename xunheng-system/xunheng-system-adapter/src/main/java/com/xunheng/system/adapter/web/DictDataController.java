package com.xunheng.system.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.DictDataService;
import com.xunheng.system.client.dto.query.DictDataPageQuery;
import com.xunheng.system.client.dto.DictDataSaveCmd;
import com.xunheng.system.client.dto.VO.DictDataVO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name="字典数据")
@RestResponse
@RequestMapping("/dictData")
public class DictDataController {

    @Resource
    DictDataService dictDataService;

    @PermissionCode("system.dictData.pageList")
    @Log(module = "字典数据",title = "字典数据分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageListByType",method = RequestMethod.GET)
    @Operation(summary = "字典数据分页列表")
    public IPage<DictDataVO> getPageListByType(DictDataPageQuery query){
        return dictDataService.pageList(query);
    }

    @PermissionCode("none")
    @RequestMapping(value = "/getByType",method = RequestMethod.GET)
    @Operation(summary = "字典数据所有列表")
    public List<DictDataVO> getByType(@RequestParam String type){
        return dictDataService.getByDictType(type);
    }

    @PermissionCode("system.dictData.add")
    @Log(module = "字典数据",title = "字典数据新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @Operation(summary = "字典数据新增")
    public DictDataVO add(@RequestBody @Validated DictDataSaveCmd cmd){
        return dictDataService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.dictData.edit")
    @Log(module = "字典数据",title = "字典数据修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "字典数据修改")
    public DictDataVO edit(@RequestBody @Validated DictDataSaveCmd cmd){
        return dictDataService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.dictData.disable")
    @Log(module = "字典数据",title = "字典数据禁用", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/disable/{dictDataId}",method = RequestMethod.POST)
    @Operation(summary = "字典数据禁用")
    @Parameters({
            @Parameter(name = "dictDataId",description = "字典数据id",in = ParameterIn.PATH),
    })
    public void disable(@PathVariable String dictDataId){
         dictDataService.updateDictStatus(dictDataId, CommonConstant.STATUS_DISABLE);
    }

    @PermissionCode("system.dictData.enable")
    @Log(module = "字典数据",title = "字典数据启用", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/enable/{dictDataId}",method = RequestMethod.POST)
    @Operation(summary = "字典数据启用")
    @Parameters({
            @Parameter(name = "dictDataId",description = "字典数据id",in = ParameterIn.PATH),
    })
    public void enable( @PathVariable String dictDataId){
         dictDataService.updateDictStatus(dictDataId, CommonConstant.STATUS_NORMAL);
    }

    @PermissionCode("system.dictData.deleteBatch")
    @Log(module = "字典数据",title = "字典数据批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "字典数据批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            dictDataService.remove(id);
        }
        return "批量通过id删除数据成功";
    }
}
