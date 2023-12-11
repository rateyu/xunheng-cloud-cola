package com.xunheng.wechat.domain.msgFeed.ability;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.MsgFeedBatchCreateCmd;
import com.xunheng.wechat.client.dto.query.WoaFansPageQuery;
import com.xunheng.wechat.domain.fans.gateway.WoaFansGateway;
import com.xunheng.wechat.domain.fans.model.WoaFansEntity;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgFeedRecordGateway;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgTemplateGateway;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgFeedRecordEntity;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgTemplateEntity;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息推送领域服务实现类
 * @author: hhqkkr
 * @date: 2023/7/25 16:45
 */
@Slf4j
@Component
public class MsgFeedDomainServiceImpl implements MsgFeedDomainService {

    @Resource
    private WxMpService wxMpService;

    @Resource
    private WoaMsgTemplateGateway woaMsgTemplateGateway;

    @Resource
    private WoaMsgFeedRecordGateway woaMsgFeedRecordGateway;

    @Resource
    private WoaFansGateway woaFansGateway;

    @Override
    public void templateSync(String appId) {
        try {
            List<WxMpTemplate> wxMpTemplateList = wxMpService.getTemplateMsgService().getAllPrivateTemplate();
            List<WoaMsgTemplateEntity> templates = wxMpTemplateList.stream().map(item->new WoaMsgTemplateEntity(item,appId)).collect(Collectors.toList());
            for (WoaMsgTemplateEntity template : templates) {
                woaMsgTemplateGateway.create(template);
            }
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendTemplateMsg(WxMpTemplateMessage msg, String appId) {
        String result;
        try {
            wxMpService.switchover(appId);
            result = wxMpService.getTemplateMsgService().sendTemplateMsg(msg);
        } catch (WxErrorException e) {
            result = e.getMessage();
        }
        /*保存发送日志*/
        WoaMsgFeedRecordEntity recordEntity = new WoaMsgFeedRecordEntity(msg,appId, result);
        woaMsgFeedRecordGateway.saveOrUpdate(recordEntity);
    }

    @Override
    public void sendMsgBatch(MsgFeedBatchCreateCmd cmd, String appId) {
        log.info("批量发送模板消息任务开始,参数：{}",cmd.toString());
        wxMpService.switchover(appId);
        WxMpTemplateMessage.WxMpTemplateMessageBuilder builder = WxMpTemplateMessage.builder()
                .templateId(cmd.getTemplateId())
                .url(cmd.getUrl())
                .miniProgram(cmd.getMiniprogram())
                .data(cmd.getData());
        /*最大批次500个一次来发送*/
        Integer currentPage=1,totalPages=Integer.MAX_VALUE;
        WoaFansPageQuery query = new WoaFansPageQuery();
        query.setAppId(appId);
        query.setPageSize(500);
        while (currentPage<=totalPages){
            query.setPage(currentPage);
            //按条件查询用户
            IPage<WoaFansEntity> wxFans = woaFansGateway.pageList(query);
            log.info("批量发送模板消息任务,使用查询条件，处理第{}页，总用户数：{}",currentPage,wxFans.getTotal());
            wxFans.getRecords().forEach(user->{
                WxMpTemplateMessage msg = builder.toUser(user.getOpenId()).build();
                this.sendTemplateMsg(msg,appId);
            });
            currentPage= Math.toIntExact(wxFans.getCurrent() + 1L);
            totalPages= Math.toIntExact(wxFans.getPages());
        }
        log.info("批量发送模板消息任务结束");
    }
}
