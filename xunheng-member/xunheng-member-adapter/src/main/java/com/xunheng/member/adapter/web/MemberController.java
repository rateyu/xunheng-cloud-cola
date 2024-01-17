package com.xunheng.member.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.member.client.api.MemberService;
import com.xunheng.member.client.dto.VO.MemberVO;
import com.xunheng.member.client.dto.query.MemberPageQuery;
import com.xunheng.member.client.dto.MemberCreateCmd;
import com.xunheng.member.client.dto.MemberUpdateCmd;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

@Tag(name="会员信息")
@RestResponse
@RequestMapping("/member")
public class MemberController {

    @Resource
    MemberService memberService;

    @PermissionCode("member.member.pageList")
    @Log(module = "会员信息",title = "会员信息分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "会员信息分页列表")
    public IPage<MemberVO> getPageList(MemberPageQuery query){
        return memberService.pageList(query);
    }

    @PermissionCode("member.member.detail")
    @Log(module = "会员信息",title = "会员信息详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @Operation(summary = "会员信息详情")
    public MemberVO getDetail(@PathVariable String id){
        return memberService.getDetail(id);
    }

    @PermissionCode("member.member.add")
    @Log(module = "会员信息",title = "会员信息新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "会员信息新增")
    public MemberVO save(@RequestBody @Validated MemberCreateCmd cmd){
       return memberService.create(cmd);
    }

    @PermissionCode("member.member.edit")
    @Log(module = "会员信息",title = "会员信息修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "会员信息修改")
    public MemberVO edit(@RequestBody @Validated MemberUpdateCmd cmd){
        return memberService.update(cmd);
    }

    @PermissionCode("member.member.deleteBatch")
    @Log(module = "会员信息",title = "会员信息批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "会员信息批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            memberService.remove(id);
        }
         return "删除成功！";
    }
}