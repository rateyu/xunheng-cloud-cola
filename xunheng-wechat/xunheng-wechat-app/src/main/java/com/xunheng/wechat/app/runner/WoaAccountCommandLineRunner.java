package com.xunheng.wechat.app.runner;

import com.xunheng.wechat.domain.wechatAccount.ability.WechatAccountDomainService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class WoaAccountCommandLineRunner implements CommandLineRunner {

    @Resource
    WechatAccountDomainService wechatAccountDomainService;

    @Override
    public void run(String... args)  {
        wechatAccountDomainService.loadWxMpConfigStorages();
    }
}
