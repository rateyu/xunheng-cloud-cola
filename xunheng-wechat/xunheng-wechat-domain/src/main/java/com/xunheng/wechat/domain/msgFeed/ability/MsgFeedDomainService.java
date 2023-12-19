package com.xunheng.wechat.domain.msgFeed.ability;

import com.xunheng.wechat.client.dto.MsgFeedBatchCreateCmd;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息推送领域服务
 * @author: hhqkkr
 * @date: 2023/7/25 16:40
 */
public interface MsgFeedDomainService {

    /**
     * 同步消息推送模板
     * @param appId appId
     */
    void templateSync(String appId);

    /**
     * 发送微信模版消息
     * @param msg 模板消息
     * @param appId appId
     */
    void sendTemplateMsg(WxMpTemplateMessage msg, String appId);

    /**
     * 批量消息发送
     * @param cmd 批量发送数据
     * @param appId appId
     */
    void sendMsgBatch(MsgFeedBatchCreateCmd cmd, String appId);

}
