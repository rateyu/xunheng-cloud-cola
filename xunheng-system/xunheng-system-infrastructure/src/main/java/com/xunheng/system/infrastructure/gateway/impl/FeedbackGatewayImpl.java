package com.xunheng.system.infrastructure.gateway.impl;

import com.xunheng.system.infrastructure.DO.Feedback;
import com.xunheng.system.domain.Feedback.model.FeedbackEntity;
import com.xunheng.system.infrastructure.convertor.FeedbackConvertor;
import com.xunheng.system.domain.Feedback.gateway.FeedbackGateway;
import com.xunheng.system.infrastructure.mapper.FeedbackMapper;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 意见反馈网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:36
 */
@Slf4j
@Component
public class FeedbackGatewayImpl implements FeedbackGateway {

    @Resource
    FeedbackMapper feedbackMapper;

    @Override
    public FeedbackEntity saveOrUpdate(FeedbackEntity entity) {
        Feedback feedback = FeedbackConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(feedback.getId()) ? feedbackMapper.insert(feedback) : feedbackMapper.updateById(feedback);
        return FeedbackConvertor.toEntity(feedback);
    }
}
