package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.system.client.api.SaSessionService;
import com.xunheng.system.client.dto.VO.SaSessionVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="session会话")
@RestResponse
@RequestMapping("/saSession")
public class SaSessionController {

    @Autowired
    SaSessionService saSessionService;

    @PermissionCode("system.saSession.pageList")
    @Log(module = "session会话",title = "session会话分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @Operation(summary = "session会话分页列表")
    public List<SaSessionVO> getAll(@RequestParam(required = false) String username){
        return saSessionService.getAll(username);
    }

    @PermissionCode("system.saSession.kickOut")
    @Log(module = "session会话",title = "session会话下线", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/kickOut/{token}",method = RequestMethod.DELETE)
    @Operation(summary = "session会话下线")
    public String kickOut(@PathVariable String token){
        saSessionService.kickOutByToken(token);
        return "下线用户成功";
    }

    @PermissionCode("system.saSession.changeSession")
    @Log(module = "session会话",title = "session会话切换身份", businessType = BusinessType.OTHER)
    @RequestMapping(value = "/changeSession/{token}",method = RequestMethod.POST)
    @Operation(summary = "session会话切换身份")
    public String changeSession(@PathVariable String token){
        saSessionService.changeSession(token);
        return "切换成功";
    }


}
