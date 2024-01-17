package com.xunheng.system.app.executor.query;

import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.system.app.assembler.PermissionAssembler;
import com.xunheng.system.domain.permission.ability.PermissionDomainService;
import com.xunheng.system.domain.permission.model.PermissionEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 系统权限查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:58
 */
@Component
public class SystemPermissionListQueryExe {

    @Resource
    private PermissionDomainService permissionDomainService;

    public List<PermissionVO> execute(){
        List<PermissionEntity> systemPermissionList = permissionDomainService.getSystemPermissionList();
        return PermissionAssembler.toTree(systemPermissionList.stream().map(PermissionAssembler::toVo).collect(Collectors.toList()));
    }

}
