package com.xunheng.auth.app;

import com.xunheng.auth.app.executor.CaptchaLoadCmdExe;
import com.xunheng.auth.client.api.CaptchaService;
import com.xunheng.auth.client.dto.VO.CaptchaVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 网关验证码service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 12:38
 */
@Service
@Slf4j
@Transactional
public class CaptchaServiceImpl implements CaptchaService {

    @Resource
    private CaptchaLoadCmdExe captchaLoadCmdExe;

    @Override
    public CaptchaVO loadCaptcha() {
        return captchaLoadCmdExe.execute();
    }

}
