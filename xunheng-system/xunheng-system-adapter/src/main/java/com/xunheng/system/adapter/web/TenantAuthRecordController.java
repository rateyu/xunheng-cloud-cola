package com.xunheng.system.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.TenantAuthRecordService;
import com.xunheng.system.client.dto.query.TenantAuthRecordPageQuery;
import com.xunheng.system.client.dto.TenantAuthRecordSaveCmd;
import com.xunheng.system.client.dto.VO.TenantAuthRecordVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("租户授权记录")
@RestController
@RequestMapping("/tenantAuthRecord")
public class TenantAuthRecordController {

    @Resource
    TenantAuthRecordService tenantAuthRecordService;

    @PermissionCode("system.tenantAuthRecord.pageList")
    @Log(module = "租户授权记录",title = "租户授权记录分页", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "租户授权记录分页")
    public IPage<TenantAuthRecordVO> getPageList(TenantAuthRecordPageQuery query){
        return tenantAuthRecordService.pageList(query);
    }

    @PermissionCode("system.tenantAuthRecord.detail")
    @Log(module = "租户授权记录",title = "租户授权记录详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getOne/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "租户授权记录详情")
    public TenantAuthRecordVO getOne(@PathVariable String id){
        return tenantAuthRecordService.getDetail(id);
    }


    @PermissionCode("system.tenantAuthRecord.add")
    @Log(module = "租户授权记录",title = "租户授权记录新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "租户授权记录新增")
    public TenantAuthRecordVO save(@RequestBody @Validated TenantAuthRecordSaveCmd cmd){
        return tenantAuthRecordService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.tenantAuthRecord.edit")
    @Log(module = "租户授权记录",title = "租户授权记录修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "租户授权记录修改")
    public TenantAuthRecordVO edit(@RequestBody @Validated TenantAuthRecordSaveCmd cmd){
        return tenantAuthRecordService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.tenantAuthRecord.deleteBatch")
    @Log(module = "租户授权记录",title = "租户授权记录批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "租户授权记录批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            tenantAuthRecordService.remove(id);
        }
        return "删除成功";
    }

}
