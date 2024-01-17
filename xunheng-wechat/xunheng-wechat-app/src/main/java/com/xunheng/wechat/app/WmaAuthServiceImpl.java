package com.xunheng.wechat.app;

import com.xunheng.wechat.app.executor.WmaAuthCmdExe;
import com.xunheng.wechat.client.api.WmaAuthService;
import com.xunheng.wechat.client.dto.VO.WmaAuthVO;
import com.xunheng.wechat.client.dto.WmaAuthCmd;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * @program: xunheng-cloud-cola
 * @description: 微信授权登录Service实现类
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Service
@GlobalTransactional
public class WmaAuthServiceImpl implements WmaAuthService {

    @Resource
    WmaAuthCmdExe wmaAuthCmdExe;

    @Override
    public WmaAuthVO wmaAuth(WmaAuthCmd cmd) {
        return wmaAuthCmdExe.execute(cmd);
    }


}