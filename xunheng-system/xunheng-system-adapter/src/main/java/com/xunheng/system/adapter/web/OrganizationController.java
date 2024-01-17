package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.OrganizationService;
import com.xunheng.system.client.dto.OrganizationCreateCmd;
import com.xunheng.system.client.dto.OrganizationUpdateCmd;
import com.xunheng.system.client.dto.VO.OrganizationVO;
import com.xunheng.system.client.dto.query.OrganizationListQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@Tag(name="组织架构")
@RestResponse
@RequestMapping("/organization")
public class OrganizationController {

    @Resource
    OrganizationService organizationService;

    @PermissionCode("system.organization.tree")
    @Log(module = "组织架构",title = "组织架构树", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @Operation(summary = "组织架构树")
    public List<OrganizationVO> getList(OrganizationListQuery query){
        return organizationService.getGroupOrganizationList(query);
    }

    @PermissionCode("system.organization.add")
    @Log(module = "组织架构",title = "组织架构新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @Operation(summary = "组织架构新增")
    public OrganizationVO add(@RequestBody @Validated OrganizationCreateCmd cmd){
        return organizationService.create(cmd);
    }

    @PermissionCode("system.organization.edit")
    @Log(module = "组织架构",title = "修改组织架构", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "编辑")
    public OrganizationVO edit(@RequestBody OrganizationUpdateCmd cmd){
        return organizationService.update(cmd);
    }

    @PermissionCode("system.organization.deleteBatch")
    @Log(module = "组织架构",title = "组织架构批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "组织架构批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            organizationService.remove(id);
        }
        return "删除成功";
    }

}
