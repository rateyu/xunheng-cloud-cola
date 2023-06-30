package com.xunheng.system.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.RoleService;
import com.xunheng.system.client.dto.RolePermEditCmd;
import com.xunheng.system.client.dto.RoleSaveCmd;
import com.xunheng.system.client.dto.query.RolePageQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api("角色")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PermissionCode("none")
    @RequestMapping(value = "/getSelectItem", method = RequestMethod.GET)
    @ApiOperation(value = "获取选择框数据")
    public List<SelectItemVO> getSelectItem() {
        return roleService.getSelectItem();
    }

    @PermissionCode("system.role.pageList")
    @Log(module = "角色",title = "角色分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "角色分页列表")
    public IPage<RoleVO> getPageList(RolePageQuery query){
        return roleService.pageList(query);
    }

    @PermissionCode("system.role.allList")
    @Log(module = "角色",title = "角色所有列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getAllList",method = RequestMethod.GET)
    @ApiOperation(value = "角色所有列表")
    public List<RoleVO> getAll(){
        return roleService.getAll();
    }

    @PermissionCode("system.role.editRolePerm")
    @Log(module = "角色",title = "角色分配权限", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/editRolePerm",method = RequestMethod.POST)
    @ApiOperation(value = "角色分配权限")
    public String editRolePerm(@RequestBody RolePermEditCmd cmd){
        roleService.editRolePerm(cmd);
        return "操作成功";
    }

    @PermissionCode("system.role.add")
    @Log(module = "角色",title = "角色新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "角色新增")
    public RoleVO save(@RequestBody @Validated RoleSaveCmd cmd){
        return roleService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.role.edit")
    @Log(module = "角色",title = "角色修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "角色修改")
    public RoleVO edit(@RequestBody @Validated RoleSaveCmd cmd){
        return roleService.saveOrUpdate(cmd);
    }

    @PermissionCode("system.role.deleteBatch")
    @Log(module = "角色",title = "角色批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delAllByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "角色批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id:ids){
            roleService.remove(id);
        }
        return "删除成功";
    }

}
