package com.xunheng.system.app;

import com.xunheng.system.client.api.FeedbackService;
import com.xunheng.system.client.dto.FeedbackSaveCmd;
import com.xunheng.system.client.dto.VO.FeedbackVO;
import com.xunheng.system.app.executor.FeedbackSaveCmdExe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 意见反馈service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    @Resource
    private FeedbackSaveCmdExe feedbackSaveCmdExe;

    @Override
    public FeedbackVO saveOrUpdate(FeedbackSaveCmd cmd) {
        return feedbackSaveCmdExe.execute(cmd);
    }
}
