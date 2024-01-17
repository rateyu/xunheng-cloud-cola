
package com.xunheng.system.app.executor;

import com.xunheng.system.domain.Feedback.model.FeedbackEntity;
import com.xunheng.system.app.assembler.FeedbackAssembler;
import com.xunheng.system.client.dto.FeedbackSaveCmd;
import com.xunheng.system.client.dto.VO.FeedbackVO;
import com.xunheng.system.domain.Feedback.gateway.FeedbackGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 意见反馈保存处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:08
 */
@Component
public class FeedbackSaveCmdExe {

    @Resource
    private FeedbackGateway feedbackGateway;

    public FeedbackVO execute(FeedbackSaveCmd cmd) {
        FeedbackEntity saveEntity = FeedbackAssembler.toSaveEntity(cmd);
        return FeedbackAssembler.toVo(feedbackGateway.saveOrUpdate(saveEntity));
    }

}
