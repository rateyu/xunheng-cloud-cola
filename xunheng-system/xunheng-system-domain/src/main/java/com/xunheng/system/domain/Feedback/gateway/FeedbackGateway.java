package com.xunheng.system.domain.Feedback.gateway;

import com.xunheng.system.domain.Feedback.model.FeedbackEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 意见反馈网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:48
 */
public interface FeedbackGateway {

    /**
     * 保存或更新意见反馈
     * @param entity 意见反馈实体
     * @return 意见反馈实体
     */
    FeedbackEntity saveOrUpdate(FeedbackEntity entity);

}
