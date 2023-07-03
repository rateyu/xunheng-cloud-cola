package com.xunheng.generator.client.api;

import com.xunheng.generator.client.dto.GenConfigSaveAndGenCmd;
import com.xunheng.generator.client.dto.GenConfigSaveCmd;
import com.xunheng.generator.client.dto.VO.GenConfigVO;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器service
 * @author: hhqkkr
 * @date: 2023/7/3 16:51
 */
public interface GenConfigService {

    /**
     * 保存配置表格
     * @param cmd 表格保存操作dto
     */
    void saveGenConfig(GenConfigSaveCmd cmd);

    /**
     * 保存配置表格并生成代码
     * @param cmd 表格保存并生成代码操作dto
     */
    void saveAndGenConfig(GenConfigSaveAndGenCmd cmd);

    /**
     * 获取生成代码表格配置
     * @return 配置VO
     */
    GenConfigVO getConfig();


}
