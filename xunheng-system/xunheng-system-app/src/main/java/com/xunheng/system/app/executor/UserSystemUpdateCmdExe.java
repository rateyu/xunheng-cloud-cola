
package com.xunheng.system.app.executor;

import cn.hutool.core.util.StrUtil;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.client.dto.UserSystemUpdateCmd;
import com.xunheng.system.domain.organization.gateway.OrganizationGateway;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.gateway.UserRoleGateway;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import com.xunheng.system.domain.user.model.UserEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.Arrays;

/**
 * @program: xunheng-cloud-cola
 * @description: 系统更新用户操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:31
 */
@Component
public class UserSystemUpdateCmdExe {

    @Resource
    private UserGateway userGateway;

    @Resource
    private UserRoleGateway userRoleGateway;

    @Resource
    private OrganizationGateway organizationGateway;

    @Resource
    private UserDomainService userDomainService;

    public UserVO execute(UserSystemUpdateCmd cmd) {
        /*如果是修改 先清除缓存*/
        if(StringUtils.isNotEmpty(cmd.getId()))userDomainService.reloadUserDetailCache(cmd.getId());
        /*校验用户名*/
        UserEntity oneByUsername = userGateway.getOneByUsername(cmd.getUsername());
        if(oneByUsername !=null && !cmd.getId().equals(oneByUsername.getId()))throw new GlobalException("该用户名已被注册");
        /*校验手机号*/
        UserEntity oneByMobile = userGateway.getOneByMobile(cmd.getMobile());
        if(oneByMobile !=null && !cmd.getId().equals(oneByMobile.getId()))throw new GlobalException("该手机号已被绑定");
        /*校验邮箱*/
        UserEntity oneByEmail = userGateway.getOneByEmail(cmd.getEmail());
        if(oneByEmail !=null && !cmd.getId().equals(oneByEmail.getId()))throw new GlobalException("该邮箱已被绑定");
        /*校验直接上级*/
        if(cmd.getSuperiorObj() != null && StringUtils.equals(cmd.getId(),cmd.getSuperiorObj().getId()))throw new GlobalException("直接上级不能是自己");
        /*校验组织架构*/
        OrganizationEntity organization = organizationGateway.getOneById(cmd.getOrganizationId()[0]);
        if (organization == null)throw new GlobalException("查询不到部门id为"+cmd.getOrganizationId()[0]+"的记录");
        if (organization.getType() == null)throw new GlobalException("部门id为"+cmd.getOrganizationId()[0]+"记录的类型为空，请联系管理员确认");
        if (!organization.getType().equals(CommonConstant.ORGANIZATION_DEPARTMENT) )throw new GlobalException("部门不能选择分公司或总公司，请确认");
        if (StrUtil.isBlank(organization.getParentId()))throw new GlobalException("查询不到部门的上级");
        /*保存*/
        UserEntity updateEntity = userGateway.saveOrUpdate(UserAssembler.toSystemUpdateEntity(cmd,organization));
        /*删除该用户角色*/
        userRoleGateway.removeByUserId(updateEntity.getId());
        /*保存用户角色信息*/
        String[] roleIds = cmd.getRoleIds();
        if(roleIds!=null)Arrays.stream(roleIds).forEach(roleId ->  userRoleGateway.create(updateEntity.getId(),roleId));
        return UserAssembler.toVo(updateEntity);
    }

}
