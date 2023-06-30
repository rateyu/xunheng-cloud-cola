package com.xunheng.system.app.assembler;

import com.xunheng.system.domain.Feedback.model.FeedbackEntity;
import com.xunheng.system.client.dto.FeedbackSaveCmd;
import com.xunheng.system.client.dto.VO.FeedbackVO;

/**
 * @program: xunheng-cloud-cola
 * @description: 意见反馈dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:29
 */
public class FeedbackAssembler {
    public static FeedbackEntity toSaveEntity(FeedbackSaveCmd cmd) {
        FeedbackEntity entity = new FeedbackEntity();
        entity.setId(cmd.getId());
        entity.setContent(cmd.getContent());
        return entity;
    }

    public static FeedbackVO toVo(FeedbackEntity entity) {
        if(entity == null)return null;
        FeedbackVO vo = new FeedbackVO();
        vo.setId(entity.getId());
        vo.setContent(entity.getContent());
        return vo;
    }
}
