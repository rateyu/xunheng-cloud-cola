package com.xunheng.system.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.system.app.assembler.PermissionAssembler;
import com.xunheng.system.client.dto.PermissionCreateCmd;
import com.xunheng.system.domain.permission.gateway.PermissionGateway;
import com.xunheng.system.domain.permission.model.PermissionEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限新增操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:18
 */
@Component
public class PermissionCreateCmdExe {

    @Resource
    private PermissionGateway permissionGateway;

    public PermissionVO execute(PermissionCreateCmd cmd) {
        /*校验名称是否存在*/
        if(permissionGateway.getOneByName(cmd.getName()) != null) throw new GlobalException("名称已存在");
        PermissionEntity createEntity = PermissionAssembler.toCreateEntity(cmd);
        return PermissionAssembler.toVo(permissionGateway.saveOrUpdate(createEntity));
    }

}
