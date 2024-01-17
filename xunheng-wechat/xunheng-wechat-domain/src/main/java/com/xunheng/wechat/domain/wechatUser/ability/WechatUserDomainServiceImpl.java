package com.xunheng.wechat.domain.wechatUser.ability;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.xunheng.base.utils.TaskExcutor;
import com.xunheng.wechat.domain.wechatUser.gateway.WechatUserGateway;
import com.xunheng.wechat.domain.wechatUser.model.UserType;
import com.xunheng.wechat.domain.wechatUser.model.WechatUserEntity;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信公众号领域服务实现类
 * @author: hhqkkr
 * @date: 2023/11/22 16:45
 */
@Slf4j
@Component
public class WechatUserDomainServiceImpl implements WechatUserDomainService {

    @Resource
    WxMpService wxMpService;


    @Resource
    WxMaService wxMaService;

    @Resource
    WechatUserGateway wechatUserGateway;

    @Value("${wx.mp.autoReplyInterval:1000}")
    Long autoReplyInterval;

    private volatile static  boolean syncWoaFansTaskRunning=false;

    @Override
    @Async
    public void syncFans(String appId) {
        //同步较慢，防止个多线程重复执行同步任务
        Assert.isTrue(!syncWoaFansTaskRunning,"后台有同步任务正在进行中，请稍后重试");
        wxMpService.switchoverTo(appId);
        syncWoaFansTaskRunning=true;
        log.info("同步公众号粉丝列表：任务开始");
        wxMpService.switchover(appId);
        boolean hasMore=true;
        String nextOpenid=null;
        WxMpUserService wxMpUserService = wxMpService.getUserService();
        try {
            int page=1;
            while (hasMore){
                WxMpUserList wxMpUserList = wxMpUserService.userList(nextOpenid);//拉取openid列表，每次最多1万个
                log.info("拉取openId列表：第{}页，数量：{}",page++,wxMpUserList.getCount());
                List<String> openIds = wxMpUserList.getOpenids();
                this.syncFans(openIds,appId);
                nextOpenid=wxMpUserList.getNextOpenid();
                hasMore= StringUtils.hasText(nextOpenid) && wxMpUserList.getCount()>=10000;
            }
        } catch (WxErrorException e) {
            log.error("同步公众号粉丝列表出错:",e);
        }finally {
            syncWoaFansTaskRunning=false;
        }
        log.info("同步公众号粉丝列表：完成");
    }

    @Override
    public void syncFans(List<String> openIds, String appId) {
        if(openIds.size()<1) {
            return;
        }
        final String batch=openIds.get(0).substring(20);//截取首个openid的一部分做批次号（打印日志时使用，无实际意义）
        WxMpUserService wxMpUserService = wxMpService.getUserService();
        int start=0,batchSize=openIds.size(),end=Math.min(100,batchSize);
        log.info("开始处理批次：{}，批次数量：{}",batch,batchSize);
        while (start<end && end<=batchSize){//分批处理,每次最多拉取100个用户信息
            final int finalStart = start,finalEnd = end;
            final List<String> subOpenids=openIds.subList(finalStart,finalEnd);
            TaskExcutor.submit(()->{//使用线程池同步数据，否则大量粉丝数据需同步时会很慢
                log.info("同步批次:【{}--{}-{}】，数量：{}",batch, finalStart, finalEnd,subOpenids.size());
                wxMpService.switchover(appId);
                List<WxMpUser> wxMpUsers = null;//批量获取用户信息，每次最多100个
                try {
                    wxMpUsers = wxMpUserService.userInfoList(subOpenids);
                } catch (WxErrorException e) {
                    log.error("同步出错，批次：【{}--{}-{}】，错误信息：{}",batch, finalStart, finalEnd,e);
                }
                if(wxMpUsers!=null && !wxMpUsers.isEmpty()){
                    List<WechatUserEntity> fans=wxMpUsers.parallelStream().map(item->WechatUserEntity.createWoaFans(item,appId)).collect(Collectors.toList());
                    for (WechatUserEntity fan : fans) {
                        fan.setType(UserType.WX_GZH.getVal());
                        //查询是否已存在
                        WechatUserEntity one = wechatUserGateway.getOneByOpenId(appId,fan.getOpenId());
                        if(one != null)fan.setId(one.getId());
                        wechatUserGateway.saveOrUpdate(fan);
                    }


                }
            });
            start=end;
            end=Math.min(end+100,openIds.size());
        }
        log.info("批次：{}处理完成",batch);
    }

    @Override
    public void refreshFansInfo(String openId, String appId) {
        try {
            // 获取微信用户基本信息
            log.info("更新用户信息，openId={}",openId);
            wxMpService.switchover(appId);
            WxMpUser fansWxInfo = wxMpService.getUserService().userInfo(openId, null);
            if (fansWxInfo == null) {
                log.error("获取不到用户信息，无法更新,openid:{}",openId);
                return;
            }
            WechatUserEntity fans = WechatUserEntity.createWoaFans(fansWxInfo,appId);
            wechatUserGateway.saveOrUpdate(fans);
        } catch (Exception e) {
            log.error("更新用户信息失败,openid:{}",openId);
        }
    }

    @Override
    public void unsubscribe(String appId,String openId) {
        WechatUserEntity fan = wechatUserGateway.getOneByOpenId(appId,openId);
        if(fan == null)return;
        fan.setSubscribe(0);
        wechatUserGateway.saveOrUpdate(fan);
    }

}
