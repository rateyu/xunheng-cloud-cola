
package com.xunheng.system.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.security.config.util.SaUtil;
import com.xunheng.system.domain.role.gateway.RoleGateway;
import com.xunheng.system.domain.role.gateway.RolePermissionGateway;
import com.xunheng.system.domain.user.gateway.UserRoleGateway;
import com.xunheng.system.domain.user.model.UserRoleEntity;
import io.seata.common.util.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色删除操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:25
 */
@Component
public class RoleRemoveCmdExe {

    @Resource
    private RoleGateway roleGateway;

    @Resource
    private UserRoleGateway userRoleGateway;

    @Resource
    RolePermissionGateway rolePermissionGateway;

    @Resource
    private SaUtil saUtil;

    public void execute(String id) {
        /*有用户使用当前角色的不能删除*/
        List<UserRoleEntity> list = userRoleGateway.getByRoleId(id);
        if(CollectionUtils.isNotEmpty(list)){
            throw new GlobalException("删除失败，包含正被用户使用关联的角色");
        }
        /*删除角色*/
        roleGateway.remove(id);
        /*删除角色权限*/
        rolePermissionGateway.deleteByRoleId(id);
        /*清除权限缓存*/
        saUtil.deleteCustomerSession("permission:*");
    }

}
