package com.xunheng.system.app;

import com.xunheng.system.app.executor.CaptchaLoadCmdExe;
import com.xunheng.system.client.api.CaptchaService;
import com.xunheng.system.client.dto.VO.CaptchaVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 登录验证码service实现类
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
