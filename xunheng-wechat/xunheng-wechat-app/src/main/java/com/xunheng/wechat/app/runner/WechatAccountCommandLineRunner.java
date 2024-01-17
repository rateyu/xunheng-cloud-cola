package com.xunheng.wechat.app.runner;

import com.xunheng.wechat.domain.account.ability.AccountDomainService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class WechatAccountCommandLineRunner implements CommandLineRunner {

    @Resource
    AccountDomainService accountDomainService;

    @Override
    public void run(String... args)  {
        accountDomainService.loadWxAccountConfigStorages();
    }
}
