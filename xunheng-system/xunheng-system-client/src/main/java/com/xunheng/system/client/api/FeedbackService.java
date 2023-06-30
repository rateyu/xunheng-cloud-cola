package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.FeedbackSaveCmd;
import com.xunheng.system.client.dto.VO.FeedbackVO;

/**
 * @program: xunheng-cloud-cola
 * @description: 意见反馈service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:06
 */
public interface FeedbackService {

    /**
     * 保存或更新意见反馈
     * @param cmd 保存操作dto
     * @return 意见反馈vo
     */
    FeedbackVO saveOrUpdate(FeedbackSaveCmd cmd);

}