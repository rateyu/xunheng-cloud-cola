package com.xunheng.system.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.UserService;
import com.xunheng.system.client.dto.UserPasswordUpdateCmd;
import com.xunheng.system.client.dto.UserSystemCreateCmd;
import com.xunheng.system.client.dto.UserSystemUpdateCmd;
import com.xunheng.system.client.dto.UserUpdateCmd;
import com.xunheng.system.client.dto.query.UserPageQuery;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;


@Tag(name="用户")
@RestResponse
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @PermissionCode("none")
    @RequestMapping(value = "/getSelectItem", method = RequestMethod.GET)
    @Operation(summary = "获取选择框数据")
    public List<SelectItemVO> getSelectItem() {
        return userService.getSelectItem();
    }

    @PermissionCode("none")
    @Log(module = "用户",title = "通过用户名找到用户", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getByUsername")
    @Operation(summary = "通过用户名找到用户")
    public UserVO getByUsername(@RequestParam(value = "username") String username){
        return userService.getUserDetailByUsername(username);
    }

    @PermissionCode("system.user.pageList")
    @Log(module = "用户",title = "用户分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "用户分页列表")
    public IPage<UserVO> getPageList( UserPageQuery query){
        log.info("123123");
        return userService.pageList(query);
    }

    @PermissionCode("system.user.adminAdd")
    @Log(module = "用户",title = "管理员添加用户", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/admin/add",method = RequestMethod.POST)
    @Operation(summary = "管理员添加用户")
    public UserVO add(@RequestBody @Validated UserSystemCreateCmd cmd){
        return userService.systemCreate(cmd);
    }

    @PermissionCode("system.user.adminEdit")
    @Log(module = "用户",title = "管理员修改资料", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/admin/edit",method = RequestMethod.POST)
    @Operation(summary = "管理员修改资料")
    public UserVO edit(@RequestBody @Validated UserSystemUpdateCmd cmd){
        return userService.systemUpdate(cmd);
    }

    @PermissionCode("none")
    @Log(module = "用户",title = "用户重置密码", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/resetPass/{ids}", method = RequestMethod.POST)
    @Operation(summary = "用户重置密码")
    public String resetPass(@PathVariable String[] ids){
        for(String id:ids){
            userService.resetPass(id);
        }
        return "操作成功";
    }

    @PermissionCode("none")
    @Log(module = "用户",title = "用户修改资料", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "用户修改资料")
    public UserVO editOwn(@RequestBody @Validated UserUpdateCmd cmd){
        return userService.update(cmd);
    }

    @PermissionCode("none")
    @Log(module = "用户",title = "用户修改密码", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/modifyPass",method = RequestMethod.POST)
    @Operation(summary = "用户修改密码")
    public String modifyPass(@RequestBody @Validated UserPasswordUpdateCmd cmd){
        userService.passwordEdit(cmd);
        return "修改密码成功";
    }

    @PermissionCode("system.user.disable")
    @Log(module = "用户",title = "用户禁用", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/admin/disable/{userId}",method = RequestMethod.POST)
    @Operation(summary = "用户禁用")
    @Parameters({
            @Parameter(name = "userId",description = "用户唯一id标识",in = ParameterIn.PATH),
    })
    public String disable( @PathVariable String userId){
        userService.disable(userId);
        return "启用成功";
    }

    @PermissionCode("system.user.enable")
    @Log(module = "用户",title = "用户启用", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/admin/enable/{userId}",method = RequestMethod.POST)
    @Operation(summary = "用户启用")
    @Parameters({
            @Parameter(name = "userId",description = "用户唯一id标识",in = ParameterIn.PATH),
    })
    public String enable( @PathVariable String userId){
        userService.enable(userId);
        return "启用成功";
    }

    @PermissionCode("none")
    @RequestMapping(value = "/info/{token}")
    @Operation(summary = "获取token用户的userInfo")
    public UserVO info(@PathVariable String token){
        return userService.getUserInfoByToken(token);
    }

    @PermissionCode("system.user.deleteBatch")
    @Log(module = "用户",title = "用户批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "用户批量删除")
    public String delAllByIds(@PathVariable String[] ids){
        for(String id:ids){
            userService.remove(id);
        }
        return "批量通过id删除数据成功";
    }



}
