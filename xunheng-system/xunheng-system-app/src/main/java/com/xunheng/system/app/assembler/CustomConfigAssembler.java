package com.xunheng.system.app.assembler;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.base.vo.system.PersonalConfigVO;
import com.xunheng.system.client.dto.SystemConfigSaveCmd;
import com.xunheng.system.client.dto.PersonalConfigSaveCmd;
import com.xunheng.system.client.dto.VO.CustomConfigVO;
import com.xunheng.system.domain.customConfig.model.CustomConfigEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 个性化配置dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:26
 */
public class CustomConfigAssembler {
    public static CustomConfigEntity toPersonalSaveEntity(PersonalConfigSaveCmd cmd) {
        CustomConfigEntity entity = new CustomConfigEntity();
        String loginId = StpUtil.getLoginId("");
        entity.setUserId(loginId);//配置当前用户的id
        entity.setPersonal(1);
        entity.setConfigType("personal");//配置类型为私人
        entity.setConfigKey(cmd.getConfigKey());
        entity.setConfigValue(cmd.getConfigValue());
        return entity;
    }

    public static CustomConfigEntity toSystemSaveEntity(SystemConfigSaveCmd cmd) {
        CustomConfigEntity entity = new CustomConfigEntity();
        entity.setId(cmd.getId());
        entity.setUserId("-1");
        entity.setPersonal(0);
        entity.setConfigTitle(cmd.getConfigTitle());
        entity.setConfigType(cmd.getConfigType());
        entity.setConfigKey(cmd.getConfigKey());
        entity.setConfigValue(cmd.getConfigValue());
        return entity;
    }


    public static CustomConfigVO toVo(CustomConfigEntity entity) {
        if(entity == null)return null;
        CustomConfigVO vo = new CustomConfigVO();
        vo.setId(entity.getId());
        vo.setPersonal(entity.getPersonal());
        vo.setUserId(entity.getUserId());
        vo.setConfigType(entity.getConfigType());
        vo.setConfigKey(entity.getConfigKey());
        vo.setConfigValue(entity.getConfigValue());
        vo.setConfigTitle(entity.getConfigTitle());
        return vo;
    }

    public static PersonalConfigVO toPersonalConfigVo(CustomConfigEntity entity) {
        if(entity == null)return null;
        PersonalConfigVO vo = new PersonalConfigVO();
        vo.setConfigKey(entity.getConfigKey());
        vo.setConfigValue(entity.getConfigValue());
        return vo;
    }


}
