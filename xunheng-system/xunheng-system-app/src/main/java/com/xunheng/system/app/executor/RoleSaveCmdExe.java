package com.xunheng.system.app.executor;

import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.security.config.util.SaUtil;
import com.xunheng.system.app.assembler.RoleAssembler;
import com.xunheng.system.client.dto.RoleSaveCmd;
import com.xunheng.system.domain.role.gateway.RoleGateway;
import com.xunheng.system.domain.role.model.RoleEntity;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色保存操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:27
 */
@Component
public class RoleSaveCmdExe {

    @Resource
    private RoleGateway roleGateway;

    @Resource
    private SaUtil saUtil;

    public RoleVO execute(RoleSaveCmd cmd) {
        RoleEntity saveEntity = RoleAssembler.toSaveEntity(cmd);
        if(cmd.getId() != null){//清除权限信息缓存
            saUtil.deleteCustomerSession("permission:*");
        }
        return RoleAssembler.toVo(roleGateway.saveOrUpdate(saveEntity));
    }
}
