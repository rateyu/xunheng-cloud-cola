package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.SystemConfigSaveCmd;
import com.xunheng.system.client.dto.VO.CustomConfigVO;
import com.xunheng.system.client.dto.PersonalConfigSaveCmd;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 自定义配置service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:00
 */
public interface CustomConfigService {

    /**
     * 保存个人配置
     * @param cmd 保存操作dto
     * @return 配置vo
     */
    CustomConfigVO savePersonalConfig(PersonalConfigSaveCmd cmd);

    /**
     * 保存系统拓展配置
     * @param cmd 保存操作dto
     * @return 配置vo
     */
    CustomConfigVO saveSystemConfig(SystemConfigSaveCmd cmd);

    /**
     * 获取系统拓展配置
     * @return 配置列表
     */
    List<CustomConfigVO> getSystemConfigList();

    /**
     * 删除配置
     * @param id 配置id
     */
    void remove(String id);





}