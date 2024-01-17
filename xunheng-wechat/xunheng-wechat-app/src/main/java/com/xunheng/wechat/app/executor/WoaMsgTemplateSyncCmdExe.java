package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WoaMsgTemplateAssembler;
import com.xunheng.wechat.domain.msgFeed.ability.MsgFeedDomainService;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgTemplateGateway;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgTemplateEntity;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板同步操作处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Component
public class WoaMsgTemplateSyncCmdExe {

    @Resource
    private MsgFeedDomainService msgFeedDomainService;

    public void execute(String appId) {
       msgFeedDomainService.templateSync(appId);
    }

}
