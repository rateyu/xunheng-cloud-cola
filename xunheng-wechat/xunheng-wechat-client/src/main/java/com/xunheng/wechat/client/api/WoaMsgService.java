package com.xunheng.wechat.client.api;

import com.xunheng.wechat.client.dto.WoaAuthCheckCmd;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息Service
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
public interface WoaMsgService {

    /**
     * 接入验证
     * @param appId appId
     * @param cmd 验证参数
     * @return
     */
    String authCheck(String appId, WoaAuthCheckCmd cmd);
}