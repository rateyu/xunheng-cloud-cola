package com.xunheng.system.app.executor.query;

import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.system.app.assembler.RoleAssembler;
import com.xunheng.system.domain.role.gateway.RoleGateway;
import com.xunheng.system.domain.role.model.RoleEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色列表查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:55
 */
@Component
public class RoleListQueryExe {

    @Resource
    RoleGateway roleGateway;

    public List<RoleVO> execute() {
        List<RoleEntity> list = roleGateway.getAll();
        return list.stream().map(RoleAssembler::toVo).collect(Collectors.toList());
    }
}
