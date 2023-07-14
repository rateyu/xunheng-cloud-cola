package com.xunheng.quartz.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.quartz.app.executor.QuartzJobLogCreateCmdExe;
import com.xunheng.quartz.app.executor.query.QuartzJobLogPageQueryExe;
import com.xunheng.quartz.client.dto.QuartzJobLogCreateCmd;
import com.xunheng.quartz.client.api.QuartzJobLogService;
import com.xunheng.quartz.client.dto.VO.QuartzJobLogVO;
import com.xunheng.quartz.client.dto.query.QuartzJobLogPageQuery;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 计划任务日志service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 18:09
 */
@Service
@GlobalTransactional
public class QuartzJobLogServiceImpl implements QuartzJobLogService {

    @Resource
    private QuartzJobLogPageQueryExe quartzJobLogPageQueryExe;

    @Resource
    private QuartzJobLogCreateCmdExe quartzJobLogCreateCmdExe;

    @Override
    public IPage<QuartzJobLogVO> pageList(QuartzJobLogPageQuery query) {
        return quartzJobLogPageQueryExe.execute(query);
    }

    @Override
    public void create(QuartzJobLogCreateCmd cmd) {
        quartzJobLogCreateCmdExe.execute(cmd);
    }
}
