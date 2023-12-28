package com.xunheng.file.adapter;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.file.client.api.CatalogueService;
import com.xunheng.file.client.dto.CatalogueSaveCmd;
import com.xunheng.file.client.dto.VO.CatalogueVO;
import com.xunheng.log.config.annotation.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name="上传目录")
@RestResponse
@RequestMapping("/catalogue")
public class CatalogueController {

    @Resource
    CatalogueService catalogueService;

    @PermissionCode("file.catalogue.tree")
    @Log(module = "上传目录",title = "上传目录树", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getAllList", method = RequestMethod.GET)
    @Operation(summary = "上传目录树")
    public List<CatalogueVO> allList(){
        return catalogueService.allList();
    }

    @PermissionCode("file.catalogue.add")
    @Log(module = "上传目录",title = "上传目录新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @Operation(summary = "上传目录新增")
    public CatalogueVO add(@RequestBody @Validated CatalogueSaveCmd cmd){
        return catalogueService.saveOrUpdate(cmd);
    }

    @PermissionCode("file.catalogue.edit")
    @Log(module = "上传目录",title = "上传目录修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "上传目录修改")
    public CatalogueVO edit(@RequestBody @Validated CatalogueSaveCmd cmd){
        return catalogueService.saveOrUpdate(cmd);
    }

    @PermissionCode("file.catalogue.deleteBatch")
    @Log(module = "上传目录",title = "上传目录批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "上传目录批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            catalogueService.remove(id);
        }
        return "删除成功";
    }

}
