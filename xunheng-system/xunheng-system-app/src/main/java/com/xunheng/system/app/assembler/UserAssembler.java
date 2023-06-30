package com.xunheng.system.app.assembler;

import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.base.vo.system.UserLoginVO;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.client.dto.UserSystemCreateCmd;
import com.xunheng.system.client.dto.UserSystemUpdateCmd;
import com.xunheng.system.client.dto.UserUpdateCmd;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import com.xunheng.system.domain.user.model.PassWord;
import com.xunheng.system.domain.user.model.UserEntity;

import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:39
 */
public class UserAssembler {
    public static UserEntity toUpdateEntity(UserUpdateCmd cmd) {
        UserEntity entity = new UserEntity();
        entity.setId(cmd.getId());
        entity.setNickName(cmd.getNickName());
        entity.setSex(cmd.getSex());
        entity.setAbout(cmd.getAbout());
        entity.setBirth(cmd.getBirth());
        entity.setMobile(cmd.getMobile());
        entity.setEmail(cmd.getEmail());
        return entity;
    }

    public static UserEntity toSystemCreateEntity(UserSystemCreateCmd cmd, OrganizationEntity organization) {
        UserEntity entity = new UserEntity();
        entity.setUsername(cmd.getUsername());
        entity.setPassword(new PassWord(cmd.getPassword()));
        entity.setNickName(cmd.getNickName());
        entity.setMobile(cmd.getMobile());
        entity.setEmail(cmd.getEmail());
        entity.setAddress(cmd.getAddress());
        entity.setStreet(cmd.getStreet());
        entity.setSex(cmd.getSex());
        entity.setBirth(cmd.getBirth());
        entity.setAbout(cmd.getAbout());
        entity.setAvatar(cmd.getAvatar());
        if(cmd.getSuperiorObj() != null)entity.setSuperior(cmd.getSuperiorObj().getId());
        entity.setType(cmd.getType());
        entity.setStatus(cmd.getStatus());
        entity.setDescription(cmd.getDescription());
        entity.setOrganizationId(cmd.getOrganizationId()[0]);
        if(cmd.getTenantObj() != null)entity.setTenantId(cmd.getTenantObj().getId());
        entity.setSubCompanyId(organization.getSubCompanyId());
        entity.setDepartmentId(entity.getOrganizationId());
        return entity;
    }

    public static UserEntity toSystemUpdateEntity(UserSystemUpdateCmd cmd, OrganizationEntity organization) {
        UserEntity entity = new UserEntity();
        entity.setId(cmd.getId());
        entity.setUsername(cmd.getUsername());
        entity.setNickName(cmd.getNickName());
        entity.setMobile(cmd.getMobile());
        entity.setEmail(cmd.getEmail());
        entity.setAddress(cmd.getAddress());
        entity.setStreet(cmd.getStreet());
        entity.setSex(cmd.getSex());
        entity.setBirth(cmd.getBirth());
        entity.setAbout(cmd.getAbout());
        entity.setAvatar(cmd.getAvatar());
        if(cmd.getSuperiorObj() != null)entity.setSuperior(cmd.getSuperiorObj().getId());
        entity.setType(cmd.getType());
        entity.setStatus(cmd.getStatus());
        entity.setDescription(cmd.getDescription());
        entity.setOrganizationId(cmd.getOrganizationId()[0]);
        if(cmd.getTenantObj() != null)entity.setTenantId(cmd.getTenantObj().getId());
        entity.setSubCompanyId(organization.getSubCompanyId());
        entity.setDepartmentId(entity.getOrganizationId());
        return entity;
    }

    public static UserVO toVo(UserEntity entity) {
        if(entity == null)return null;
        UserVO vo = new UserVO();
        vo.setId(entity.getId());
        vo.setCreateTime(entity.getCreateTime());
        vo.setUsername(entity.getUsername());
        vo.setNickName(entity.getNickName());
        vo.setMobile(entity.getMobile());
        vo.setEmail(entity.getEmail());
        vo.setAddress(entity.getAddress());
        vo.setStreet(entity.getStreet());
        vo.setSex(entity.getSex());
        vo.setBirth(entity.getBirth());
        vo.setAbout(entity.getAbout());
        vo.setAvatar(entity.getAvatar());
        vo.setType(entity.getType());
        vo.setStatus(entity.getStatus());
        vo.setDescription(entity.getDescription());
        vo.setOrganizationId(entity.getOrganizationId());
        vo.setTenantId(entity.getTenantId());
        vo.setSubCompanyId(entity.getSubCompanyId());
        vo.setSuperior(entity.getSuperior());
        vo.setTenantTitle(entity.getTenantTitle());
        vo.setSubCompanyTitle(entity.getSubCompanyTitle());
        vo.setDepartmentTitle(entity.getDepartmentTitle());
        vo.setSuperiorUsername(entity.getSuperiorUsername());
        if(entity.getRoles() != null)vo.setRoles(entity.getRoles().stream().map(UserRoleAssembler::toVo).collect(Collectors.toList()));
        vo.setRoleIds(entity.getRoleIds());
        vo.setUserLowIds(entity.getUserLowIds());
        vo.setDepartmentLowIds(entity.getDepartmentLowIds());
        if(entity.getPersonalConfigs() != null)vo.setPersonalConfigs(entity.getPersonalConfigs().stream().map(CustomConfigAssembler::toPersonalConfigVo).collect(Collectors.toList()));
        return vo;
    }

    public static SelectItemVO toSelectItem(UserEntity entity) {
        if(entity == null)return null;
        SelectItemVO item = new SelectItemVO();
        item.setTitle(entity.getUsername());
        item.setValue(entity.getId());
        item.setId(entity.getId());
        return item;
    }

    public static UserLoginVO toUserLoginVO(UserEntity entity) {
        if(entity == null)return null;
        UserLoginVO vo = new UserLoginVO();
        vo.setId(entity.getId());
        vo.setTenantId(entity.getTenantId());
        vo.setUsername(entity.getUsername());
        if(entity.getPassword() != null)vo.setPassword(entity.getPassword().getEncryptionPassWord().getPassword());
        return vo;
    }
}
