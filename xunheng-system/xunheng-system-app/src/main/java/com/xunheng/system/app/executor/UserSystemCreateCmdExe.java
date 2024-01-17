
package com.xunheng.system.app.executor;

import cn.hutool.core.util.StrUtil;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.client.dto.UserSystemCreateCmd;
import com.xunheng.system.domain.organization.gateway.OrganizationGateway;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.gateway.UserRoleGateway;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.Arrays;

/**
 * @program: xunheng-cloud-cola
 * @description: 系统新增用户操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:33
 */
@Component
public class UserSystemCreateCmdExe {

    @Resource
    private UserGateway userGateway;

    @Resource
    private UserRoleGateway userRoleGateway;

    @Resource
    private OrganizationGateway organizationGateway;

    public UserVO execute(UserSystemCreateCmd cmd) {
        /*校验用户名*/
        if(userGateway.getOneByUsername(cmd.getUsername()) !=null)throw new GlobalException("该用户名已被注册");
        /*校验手机号*/
        if(userGateway.getOneByMobile(cmd.getUsername()) !=null)throw new GlobalException("该手机号已被绑定");
        /*校验邮箱*/
        if(userGateway.getOneByEmail(cmd.getEmail()) !=null)throw new GlobalException("该邮箱已被绑定");
        /*校验组织架构*/
        OrganizationEntity organization = organizationGateway.getOneById(cmd.getOrganizationId()[0]);
        if (organization == null)throw new GlobalException("查询不到部门id为"+cmd.getOrganizationId()[0]+"的记录");
        if (organization.getType() == null)throw new GlobalException("部门id为"+cmd.getOrganizationId()[0]+"记录的类型为空，请联系管理员确认");
        if (!organization.getType().equals(CommonConstant.ORGANIZATION_DEPARTMENT) )throw new GlobalException("部门不能选择分公司或总公司，请确认");
        if (StrUtil.isBlank(organization.getParentId()))throw new GlobalException("查询不到部门的上级");
        UserEntity createEntity = userGateway.saveOrUpdate(UserAssembler.toSystemCreateEntity(cmd,organization));
        /*保存用户角色信息*/
        String[] roleIds = cmd.getRoleIds();
        if(roleIds!=null)Arrays.stream(roleIds).forEach(roleId ->  userRoleGateway.create(createEntity.getId(),roleId));
        return UserAssembler.toVo(createEntity);
    }

}
