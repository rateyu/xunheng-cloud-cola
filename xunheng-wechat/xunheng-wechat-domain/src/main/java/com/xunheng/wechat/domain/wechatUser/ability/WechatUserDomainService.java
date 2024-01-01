package com.xunheng.wechat.domain.wechatUser.ability;

import com.xunheng.wechat.domain.wechatUser.model.WechatUserEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户基础功能领域服务
 * @author: hhqkkr
 * @date: 2023/7/25 16:40
 */
public interface WechatUserDomainService {

    /**
     * 同步公众号粉丝
     * @param appId appId
     */
    void syncFans(String appId);

    /**
     * 同步指定的公众号粉丝
     * @param openIds openIds
     * @param appId appId
     */
    void syncFans(List<String> openIds,String appId);


    /**
     * 根据openid更新公众号粉丝信息
     * @param openId openId
     * @param appId appId
     */
     void refreshFansInfo(String openId, String appId);

    /**
     * 粉丝取消关注
     * @param appId appId
     * @param openId openId
     */
     void unsubscribe(String appId,String openId);

}
