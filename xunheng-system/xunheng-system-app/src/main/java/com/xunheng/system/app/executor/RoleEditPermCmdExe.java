
package com.xunheng.system.app.executor;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.security.config.util.SaUtil;
import com.xunheng.system.domain.role.gateway.RoleGateway;
import com.xunheng.system.domain.role.gateway.RolePermissionGateway;
import com.xunheng.system.client.dto.RolePermEditCmd;
import com.xunheng.system.domain.role.model.RoleEntity;
import com.xunheng.system.domain.role.model.RolePermissionEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色权限编辑处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:23
 */
@Component
public class RoleEditPermCmdExe {

    @Resource
    private RoleGateway roleGateway;

    @Resource
    RolePermissionGateway rolePermissionGateway;

    @Resource
    private SaUtil saUtil;

    public void execute(RolePermEditCmd cmd) {
        if(cmd.getDataType() == null)throw new GlobalException("缺失数据权限类型标识");
        /*删除其关联权限*/
        rolePermissionGateway.deleteByRoleId(cmd.getRoleId());
        /*重置为初始权限*/
        RoleEntity role = roleGateway.getById(cmd.getRoleId());
        role.setDataLevel(CommonConstant.DATA_LEVEL_NONE);
        role.setCustomExpression("");
        role.setIncludeLow(-1);
        /*分配数据权限*/
        role.setDataType(cmd.getDataType());
        /*分配新菜单权限*/
        for(String permId : cmd.getMenuHalfCheckIds()){
            rolePermissionGateway.create(new RolePermissionEntity(cmd.getRoleId(),permId,0));
        }
        for(String permId : cmd.getMenuAllCheckIds()){
            rolePermissionGateway.create(new RolePermissionEntity(cmd.getRoleId(),permId,1));
        }
        /*配置数据权限*/
        Integer dataLevel = cmd.getDataLevel();
        Integer dataType = cmd.getDataType();
        Integer includeLow = cmd.getIncludeLow();
        if(Objects.equals(dataType, CommonConstant.DATA_TYPE_LEVEL)){//根据级别
            role.setDataLevel(dataLevel);
            if(Objects.equals(dataLevel, CommonConstant.DATA_LEVEL_DEPARTMENT) || Objects.equals(dataLevel, CommonConstant.DATA_LEVEL_SINGLE))role.setIncludeLow(includeLow);
        }else if(Objects.equals(dataType, CommonConstant.DATA_TYPE_SCOPE)){//根据组织架构范围 未开源
        }else if(Objects.equals(dataType, CommonConstant.DATA_TYPE_CUSTOM)){//根据表达式 未开源
        }
        /*保存角色信息*/
        roleGateway.saveOrUpdate(role);
        /*删除权限缓存*/
        saUtil.deleteCustomerSession("permission:*");
    }

}
