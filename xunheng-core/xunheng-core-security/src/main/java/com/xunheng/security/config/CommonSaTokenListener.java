package com.xunheng.security.config;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: xunheng-cloud-cola
 * @description:sa token 监听
 * @author: hhqkkr
 * @create: 2021-12-15 18:11
 */
@Slf4j
@Component
public class CommonSaTokenListener implements SaTokenListener {

    /** 每次登录时触发 */
    @Override
    public void doLogin(String loginType, Object loginId, SaLoginModel loginModel) {
        // ...
    }

    /** 每次注销时触发 */
    @Override
    public void doLogout(String loginType, Object loginId, String tokenValue) {
        log.info("触发注销"+loginId);
    }

    /** 每次被踢下线时触发 */
    @Override
    public void doKickout(String loginType, Object loginId, String tokenValue) {
        log.info("触发被踢下线"+loginId);
    }

    /** 每次被顶下线时触发 */
    @Override
    public void doReplaced(String loginType, Object loginId, String tokenValue) {
        log.info("触发被顶下线"+loginId);
    }

    /** 每次被封禁时触发 */
    @Override
    public void doDisable(String loginType, Object loginId, long disableTime) {
        log.info("触发被封禁"+loginId);
    }

    /** 每次被解封时触发 */
    @Override
    public void doUntieDisable(String loginType, Object loginId) {
        log.info("触发被解封"+loginId);
    }

    /** 每次创建Session时触发 */
    @Override
    public void doCreateSession(String id) {
        log.info("触发创建Session "+id);
    }

    /** 每次注销Session时触发 */
    @Override
    public void doLogoutSession(String id) {
        log.info("触发注销Session "+id);
    }

}
