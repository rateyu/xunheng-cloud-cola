
package com.xunheng.system.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.system.domain.organization.gateway.OrganizationGateway;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import com.xunheng.system.domain.user.model.UserEntity;
import io.seata.common.util.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构删除操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:16
 */
@Component
public class OrganizationRemoveCmdExe {

    @Resource
    private OrganizationGateway organizationGateway;

    @Resource
    private UserGateway userGateway;

    public void execute(String id) {
        /*部门下有用户的不能删除*/
        List<UserEntity> list = userGateway.getByDepartmentId(id);
        if(CollectionUtils.isNotEmpty(list)){
            throw new GlobalException("删除失败，包含正被用户使用关联的部门");
        }
        /*部门下有下级部门的不能删除*/
        List<OrganizationEntity> sonOrganizations = organizationGateway.getByParentId(id);
        if(CollectionUtils.isNotEmpty(sonOrganizations)){
            throw new GlobalException("删除的组织包含下级部门，请先删除下级部门");
        }
        organizationGateway.remove(id);
    }

}
