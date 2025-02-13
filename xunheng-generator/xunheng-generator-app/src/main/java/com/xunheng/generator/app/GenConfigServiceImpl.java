package com.xunheng.generator.app;

import com.xunheng.generator.app.executor.GenConfigSaveAndGenCmdExe;
import com.xunheng.generator.app.executor.GenConfigSaveAndGenFrontCmdExe;
import com.xunheng.generator.app.executor.GenConfigSaveCmdExe;
import com.xunheng.generator.app.executor.query.GenConfigQueryCmdExe;
import com.xunheng.generator.client.api.GenConfigService;
import com.xunheng.generator.client.dto.GenConfigSaveAndGenCmd;
import com.xunheng.generator.client.dto.GenConfigSaveCmd;
import com.xunheng.generator.client.dto.VO.FrontCodeVO;
import com.xunheng.generator.client.dto.VO.GenConfigVO;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器service实现类
 * @author: hhqkkr
 * @date: 2023/7/3 16:56
 */
@Service
@GlobalTransactional
public class GenConfigServiceImpl implements GenConfigService {

    @Resource
    GenConfigSaveCmdExe genConfigSaveCmdExe;

    @Resource
    GenConfigSaveAndGenCmdExe genConfigSaveAndGenCmdExe;

    @Resource
    GenConfigSaveAndGenFrontCmdExe genConfigSaveAndGenFrontCmdExe;

    @Resource
    GenConfigQueryCmdExe genConfigQueryCmdExe;

    @Override
    public void saveGenConfig(GenConfigSaveCmd cmd) {
        genConfigSaveCmdExe.execute(cmd);
    }

    @Override
    public void saveAndGenConfig(GenConfigSaveAndGenCmd cmd) {
        genConfigSaveAndGenCmdExe.execute(cmd);
    }

    @Override
    public FrontCodeVO saveAndGenConfigFront(GenConfigSaveAndGenCmd cmd) {
        return genConfigSaveAndGenFrontCmdExe.execute(cmd);
    }

    @Override
    public GenConfigVO getConfig() {
        return genConfigQueryCmdExe.execute();
    }
}
