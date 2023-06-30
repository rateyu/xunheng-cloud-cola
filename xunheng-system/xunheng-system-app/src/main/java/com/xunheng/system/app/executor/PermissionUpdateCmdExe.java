package com.xunheng.system.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.security.config.util.SaUtil;
import com.xunheng.system.app.assembler.PermissionActionAssembler;
import com.xunheng.system.app.assembler.PermissionAssembler;
import com.xunheng.system.client.dto.PermissionUpdateCmd;
import com.xunheng.system.domain.permission.gateway.PermissionActionGateway;
import com.xunheng.system.domain.permission.gateway.PermissionGateway;
import com.xunheng.system.domain.permission.model.PermissionEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限新增操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:20
 */
@Component
public class PermissionUpdateCmdExe {

    @Resource
    private PermissionGateway permissionGateway;

    @Resource
    private PermissionActionGateway permissionActionGateway;

    @Resource
    private SaUtil saUtil;

    public PermissionVO execute(PermissionUpdateCmd cmd) {
        /*校验名称不能重复*/
        PermissionEntity check = permissionGateway.getOneByName(cmd.getName());
        if(check!=null && !check.getId().equals(cmd.getId())) throw new GlobalException("名称已存在");
        PermissionEntity updateEntity = PermissionAssembler.toUpdateEntity(cmd);
        updateEntity = permissionGateway.saveOrUpdate(updateEntity);
        /*删除原来的功能列表*/
        permissionActionGateway.removeByPermissionId(updateEntity.getId());
        /*重新保存功能列表*/
        if(cmd.getActionList() != null)permissionActionGateway.batchCreate(updateEntity.getId(),cmd.getActionList().stream().map(PermissionActionAssembler::toSaveEntity).collect(Collectors.toList()));
        /*清除permission缓存*/
        saUtil.deleteCustomerSession("permission:*");
        return PermissionAssembler.toVo(updateEntity);
    }

}
