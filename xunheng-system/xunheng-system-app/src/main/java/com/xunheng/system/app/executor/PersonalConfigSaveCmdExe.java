
package com.xunheng.system.app.executor;

import com.xunheng.system.app.assembler.CustomConfigAssembler;
import com.xunheng.system.client.dto.PersonalConfigSaveCmd;
import com.xunheng.system.client.dto.VO.CustomConfigVO;
import com.xunheng.system.domain.customConfig.model.CustomConfigEntity;
import com.xunheng.system.domain.customConfig.gateway.CustomConfigGateway;
import com.xunheng.system.domain.user.gateway.UserGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 个人个性化配置保存操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:22
 */
@Component
public class PersonalConfigSaveCmdExe {
    @Resource
    private CustomConfigGateway customConfigGateway;

    @Resource
    private UserGateway userGateway;

    public CustomConfigVO execute(PersonalConfigSaveCmd cmd) {
        /*转换为个性化设置领域实体*/
        CustomConfigEntity entity = CustomConfigAssembler.toPersonalSaveEntity(cmd);
        /*保存设置*/
        entity = customConfigGateway.savePersonalConfig(entity);
        /*清除个人信息缓存*/
        userGateway.cleanUserDetailCache(entity.getUserId());
        return CustomConfigAssembler.toVo(entity);
    }

}
