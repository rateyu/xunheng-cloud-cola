package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.PermissionService;
import com.xunheng.system.client.dto.PermissionCreateCmd;
import com.xunheng.system.client.dto.PermissionUpdateCmd;
import com.xunheng.system.client.dto.VO.UserPermissionVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name="权限菜单")
@RestResponse
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    PermissionService permissionService;

    @RequestMapping(value = "/getUserPermission", method = RequestMethod.GET)
    @Operation(summary = "获取当前用户所有权限数据")
    public UserPermissionVO getUserPermission(){
        return permissionService.getUserPermission();
    }

    @PermissionCode("system.permission.tree")
    @Log(module = "权限菜单",title = "权限菜单树", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getAllList", method = RequestMethod.GET)
    @Operation(summary = "权限菜单树")
    public List<PermissionVO> getAllList(){
        return permissionService.getSystemPermissionList();
    }

    @PermissionCode("system.permission.add")
    @Log(module = "权限菜单",title = "权限菜单新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Operation(summary = "权限菜单新增")
    public PermissionVO add(@RequestBody @Validated PermissionCreateCmd cmd){
        return permissionService.create(cmd);
    }

    @PermissionCode("system.permission.edit")
    @Log(module = "权限菜单",title = "权限菜单修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Operation(summary = "权限菜单修改")
    public PermissionVO edit(@RequestBody @Validated PermissionUpdateCmd cmd){
        return permissionService.update(cmd);
    }

    @PermissionCode("system.permission.deleteBatch")
    @Log(module = "权限菜单",title = "权限菜单批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}", method = RequestMethod.DELETE)
    @Operation(summary = "权限菜单批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id:ids){
            permissionService.remove(id);
        }
        return "删除成功";
    }

}
