package com.xunheng.system.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.TenantService;
import com.xunheng.system.client.dto.query.TenantPageQuery;
import com.xunheng.system.client.dto.TenantSaveCmd;
import com.xunheng.system.client.dto.VO.TenantVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("租户")
@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Resource
    TenantService tenantService;

    @PermissionCode("system.tenant.pageList")
    @Log(module = "租户",title = "租户分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "租户分页列表")
    public IPage<TenantVO> getPageList(TenantPageQuery query){
        return tenantService.pageList(query);
    }

    @PermissionCode("system.tenant.detail")
    @Log(module = "租户",title = "租户详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getOne/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "租户详情")
    public TenantVO getOne(@PathVariable String id){
        return tenantService.getDetail(id);
    }

    @PermissionCode("system.tenant.add")
    @Log(module = "租户",title = "租户新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "租户新增")
    public TenantVO save(@RequestBody @Validated TenantSaveCmd cmd){
        return tenantService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.tenant.edit")
    @Log(module = "租户",title = "租户修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "租户修改")
    public TenantVO edit(@RequestBody @Validated TenantSaveCmd cmd){
        return tenantService.saveOrUpdate(cmd);
    }


    @PermissionCode("system.tenant.deleteBatch")
    @Log(module = "租户",title = "租户批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "租户批量删除")
    public String delByIds(@PathVariable String[] ids){
       for(String id : ids){ tenantService.remove(id);}
       return "删除成功！";
    }

}
