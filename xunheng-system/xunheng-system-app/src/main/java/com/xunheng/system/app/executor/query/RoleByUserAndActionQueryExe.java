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
 * @description: 根据用户与操作码查询角色处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:51
 */
@Component
public class RoleByUserAndActionQueryExe {

    @Resource
    private RoleGateway roleGateway;

    public List<RoleVO> execute(String userId, String code){
        /*查询出角色列表*/
        List<RoleEntity> roleList = roleGateway.getRoleByUserAndAction(userId, code);
        return roleList.stream().map(RoleAssembler::toVo).collect(Collectors.toList());
    }
}
