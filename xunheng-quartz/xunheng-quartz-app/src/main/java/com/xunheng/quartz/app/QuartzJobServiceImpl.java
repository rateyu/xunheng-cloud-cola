package com.xunheng.quartz.app;

import com.xunheng.quartz.app.executor.*;
import com.xunheng.quartz.app.executor.query.QuartzJobListAllQueryExe;
import com.xunheng.quartz.client.api.QuartzJobService;
import com.xunheng.quartz.client.dto.QuartzJobCreateCmd;
import com.xunheng.quartz.client.dto.QuartzJobUpdateCmd;
import com.xunheng.quartz.client.dto.VO.QuartzJobVO;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 18:09
 */
@Service
@GlobalTransactional
public class QuartzJobServiceImpl implements QuartzJobService {

    @Resource
    QuartzJobListAllQueryExe quartzJobListAllQueryExe;

    @Resource
    QuartzJobCreateCmdExe quartzJobCreateCmdExe;

    @Resource
    QuartzJobResumeCmdExe quartzJobResumeCmdExe;

    @Resource
    QuartzJobPauseCmdExe quartzJobPauseCmdExe;

    @Resource
    QuartzJobUpdateCmdExe quartzJobUpdateCmdExe;

    @Resource
    QuartzJobRemoveCmdExe quartzJobRemoveCmdExe;

    @Resource
    QuartzJobExecuteOnceCmdExe quartzJobExecuteOnceCmdExe;

    @Override
    public List<QuartzJobVO> getAll() {
        return quartzJobListAllQueryExe.execute();
    }

    @Override
    public void create(QuartzJobCreateCmd cmd) {
        quartzJobCreateCmdExe.execute(cmd);
    }

    @Override
    public void pause(String id) {
        quartzJobPauseCmdExe.execute(id);
    }

    @Override
    public void resume(String id) {
        quartzJobResumeCmdExe.execute(id);
    }

    @Override
    public void update(QuartzJobUpdateCmd cmd) {
        quartzJobUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        quartzJobRemoveCmdExe.execute(id);
    }

    @Override
    public void executeOnce(String id) {
        quartzJobExecuteOnceCmdExe.execute(id);
    }
}
