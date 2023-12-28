package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.app.executor.WechatAccountCreateCmdExe;
import com.xunheng.wechat.app.executor.WechatAccountRemoveCmdExe;
import com.xunheng.wechat.app.executor.WechatAccountUpdateCmdExe;
import com.xunheng.wechat.app.executor.WoaAuthCheckCmdExe;
import com.xunheng.wechat.app.executor.query.WechatAccountDetailQueryExe;
import com.xunheng.wechat.app.executor.query.WechatAccountPageQueryExe;
import com.xunheng.wechat.client.api.WechatAccountService;
import com.xunheng.wechat.client.api.WoaMsgService;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.client.dto.WechatAccountCreateCmd;
import com.xunheng.wechat.client.dto.WechatAccountUpdateCmd;
import com.xunheng.wechat.client.dto.WoaAuthCheckCmd;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息Service实现类
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Service
@GlobalTransactional
public class WoaMsgServiceImpl implements WoaMsgService {

    @Resource
    WoaAuthCheckCmdExe woaAuthCheckCmdExe;

    @Override
    public String authCheck(String appId, WoaAuthCheckCmd cmd) {
        return woaAuthCheckCmdExe.execute(appId,cmd);
    }
}