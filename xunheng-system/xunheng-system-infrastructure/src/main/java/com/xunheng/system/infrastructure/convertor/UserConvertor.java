package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.User;
import com.xunheng.system.domain.user.model.PassWord;
import com.xunheng.system.domain.user.model.UserEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class UserConvertor {
    public static User toDO(UserEntity entity) {
        User db = new User();
        db.setId(entity.getId());
        db.setUsername(entity.getUsername());
        if(entity.getPassword() != null)db.setPassword(entity.getPassword().getEncryptionPassWord().getPassword());
        db.setNickName(entity.getNickName());
        db.setMobile(entity.getMobile());
        db.setEmail(entity.getEmail());
        db.setAddress(entity.getAddress());
        db.setStreet(entity.getStreet());
        db.setSex(entity.getSex());
        db.setBirth(entity.getBirth());
        db.setAbout(entity.getAbout());
        db.setAvatar(entity.getAvatar());
        db.setSuperior(entity.getSuperior());
        db.setType(entity.getType());
        db.setStatus(entity.getStatus());
        db.setDescription(entity.getDescription());
        db.setOrganizationId(entity.getOrganizationId());
        db.setTenantId(entity.getTenantId());
        return db;
    }

    public static UserEntity toEntity(User db) {
        if(db == null)return null;
        UserEntity entity = new UserEntity();
        entity.setId(db.getId());
        entity.setCreateTime(db.getCreateTime());
        entity.setDepartmentId(db.getDepartmentId());
        entity.setSubCompanyId(db.getSubCompanyId());
        entity.setUsername(db.getUsername());
        entity.setPassword(new PassWord(new PassWord.EncryptionPassWord(db.getPassword())));
        entity.setNickName(db.getNickName());
        entity.setMobile(db.getMobile());
        entity.setEmail(db.getEmail());
        entity.setAddress(db.getAddress());
        entity.setStreet(db.getStreet());
        entity.setSex(db.getSex());
        entity.setBirth(db.getBirth());
        entity.setAbout(db.getAbout());
        entity.setAvatar(db.getAvatar());
        entity.setSuperior(db.getSuperior());
        entity.setType(db.getType());
        entity.setStatus(db.getStatus());
        entity.setDescription(db.getDescription());
        entity.setOrganizationId(db.getOrganizationId());
        entity.setTenantId(db.getTenantId());
        entity.setTenantTitle(db.getTenantTitle());
        entity.setSubCompanyTitle(db.getSubCompanyTitle());
        entity.setDepartmentTitle(db.getDepartmentTitle());
        entity.setSuperiorUsername(db.getSuperiorUsername());
        return entity;
    }
}
