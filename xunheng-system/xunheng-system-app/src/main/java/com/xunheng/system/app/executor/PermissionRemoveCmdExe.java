
package com.xunheng.system.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.security.config.util.SaUtil;
import com.xunheng.system.domain.permission.gateway.PermissionGateway;
import com.xunheng.system.domain.role.gateway.RolePermissionGateway;
import com.xunheng.system.domain.role.model.RolePermissionEntity;
import io.seata.common.util.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限删除操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:19
 */
@Component
public class PermissionRemoveCmdExe {

    @Resource
    private PermissionGateway permissionGateway;

    @Resource
    private RolePermissionGateway rolePermissionGateway;

    @Resource
    private SaUtil saUtil;

    public void execute(String id) {
        /*有角色在使用的 不能删除*/
        List<RolePermissionEntity> list = rolePermissionGateway.getByPermissionId(id);
        if(CollectionUtils.isNotEmpty(list)){
            throw new GlobalException("删除失败，包含正被角色使用关联的菜单或权限");
        }
        /*删除*/
        permissionGateway.remove(id);
        /*清除权限缓存*/
        saUtil.deleteCustomerSession("permission:*");
    }

}
