package com.xunheng.auth.client.api;

import com.xunheng.auth.client.dto.VO.CaptchaVO;

/**
 * @program: xunheng-cloud-cola
 * @description: 网关验证码service
 * @author: hhqkkr
 * @date: 2023/6/29 12:34
 */
public interface CaptchaService {

    /**
     * 加载验证码
     * @return 验证码VO
     */
    CaptchaVO loadCaptcha();

}
