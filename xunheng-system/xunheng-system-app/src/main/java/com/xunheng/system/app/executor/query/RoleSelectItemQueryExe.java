package com.xunheng.system.app.executor.query;

import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.system.app.assembler.RoleAssembler;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.domain.role.gateway.RoleGateway;
import com.xunheng.system.domain.role.model.RoleEntity;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色选择器查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:56
 */
@Component
public class RoleSelectItemQueryExe {

    @Resource
    private RoleGateway roleGateway;


    public List<SelectItemVO> execute(){
        List<RoleEntity> list = roleGateway.getSelectItem();
        return list.stream().map(RoleAssembler::toSelectItem).collect(Collectors.toList());
    }


}
