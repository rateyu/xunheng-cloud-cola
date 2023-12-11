package com.xunheng.wechat.domain.fans.ability;

import com.xunheng.wechat.domain.fans.model.WoaFansEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信公众号基础功能领域服务
 * @author: hhqkkr
 * @date: 2023/7/25 16:40
 */
public interface FansDomainService {

    /**
     * 同步公众号粉丝
     * @param appId appId
     */
    void syncFans(String appId);

    /**
     * 同步指定的粉丝
     * @param openIds openIds
     * @param appId appId
     */
    void syncFans(List<String> openIds,String appId);


    /**
     * 根据openid更新用户信息
     * @param openId openId
     * @param appId appId
     */
     void refreshFansInfo(String openId, String appId);

    /**
     * 粉丝取消关注
     * @param openId openId
     */
     void unsubscribe(String openId);
}
