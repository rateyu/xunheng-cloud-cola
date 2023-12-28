package com.xunheng.system.app.executor;

import com.xunheng.system.app.assembler.CaptchaAssembler;
import com.xunheng.system.client.dto.VO.CaptchaVO;
import com.xunheng.system.domain.login.gateway.LoginGateway;
import com.xunheng.system.domain.login.model.CaptchaEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;


/**
 * @program: xunheng-cloud-cola
 * @description: 验证码加载操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 12:49
 */
@Component
public class CaptchaLoadCmdExe {

    @Resource
    private LoginGateway captchaGateway;

    public CaptchaVO execute(){
        /*验证码领域构造器直接生成一个验证码 其中已经包含验证码信息*/
        CaptchaEntity captcha = new CaptchaEntity();
        /*验证码存入redis缓存 存储时间为2分钟*/
        captchaGateway.cacheCaptcha(captcha);
        /*转换vo 去掉其中的code*/
        return CaptchaAssembler.toVo(captcha);
    }
}
