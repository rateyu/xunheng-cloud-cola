package com.xunheng.system.app;

import com.xunheng.system.client.api.CustomConfigService;
import com.xunheng.system.client.dto.SystemConfigSaveCmd;
import com.xunheng.system.client.dto.PersonalConfigSaveCmd;
import com.xunheng.system.client.dto.VO.CustomConfigVO;
import com.xunheng.system.app.executor.SystemConfigSaveCmdExe;
import com.xunheng.system.app.executor.PersonalConfigSaveCmdExe;
import com.xunheng.system.app.executor.CustomConfigRemoveCmdExe;
import com.xunheng.system.app.executor.query.SystemConfigListQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 个性化配置service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class CustomConfigServiceImpl implements CustomConfigService {

    @Resource
    private PersonalConfigSaveCmdExe personalConfigSaveCmdExe;

    @Resource
    private SystemConfigSaveCmdExe systemConfigSaveCmdExe;

    @Resource
    private SystemConfigListQueryExe systemConfigListQueryExe;

    @Resource
    private CustomConfigRemoveCmdExe customConfigRemoveCmdExe;

    @Override
    public CustomConfigVO savePersonalConfig(PersonalConfigSaveCmd cmd) {
        return personalConfigSaveCmdExe.execute(cmd);
    }

    @Override
    public CustomConfigVO saveSystemConfig(SystemConfigSaveCmd cmd) {
        return systemConfigSaveCmdExe.execute(cmd);
    }

    @Override
    public List<CustomConfigVO> getSystemConfigList() {
        return systemConfigListQueryExe.execute();
    }

    @Override
    public void remove(String id) {
        customConfigRemoveCmdExe.execute(id);
    }
}
