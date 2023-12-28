package com.xunheng.wechat.client.api;

import com.xunheng.wechat.client.dto.VO.WmaAuthVO;
import com.xunheng.wechat.client.dto.WmaAuthCmd;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信验证Service
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
public interface WmaAuthService {

    /**
     * 接入验证
     * @param cmd 登录验证操作参数
     * @return 登录结果VO
     */
    WmaAuthVO wmaAuth(WmaAuthCmd cmd);
}