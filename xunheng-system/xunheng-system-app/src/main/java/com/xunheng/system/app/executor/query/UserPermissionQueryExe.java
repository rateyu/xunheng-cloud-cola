package com.xunheng.system.app.executor.query;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.system.app.assembler.PermissionAssembler;
import com.xunheng.system.client.dto.VO.UserPermissionVO;
import com.xunheng.system.domain.permission.ability.PermissionDomainService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户权限查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:05
 */
@Component
public class UserPermissionQueryExe {

    @Resource
    private PermissionDomainService permissionDomainService;

    public UserPermissionVO execute(){
        /*校验登录*/
        String userId = StpUtil.getLoginId(null);
        if(userId == null)throw new GlobalException("用户未登录");
        /*用户权限列表*/
        List<PermissionVO> permissionList = (permissionDomainService.getPermissionListByUserId(userId))
                .stream().map(PermissionAssembler::toVo).collect(Collectors.toList());
        /*用户权对应的权限码集合限列表*/
        List<String> userPermissionCodes = permissionDomainService.getUserPermissionCodes(userId);
        return new UserPermissionVO(PermissionAssembler.toTree(permissionList),userPermissionCodes);
    }



}
