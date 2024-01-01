package com.xunheng.wechat.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.VO.WechatUserVO;
import com.xunheng.wechat.client.dto.query.WechatUserPageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户service
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
public interface WechatUserService{

    /**
     * 微信用户分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WechatUserVO> pageList(WechatUserPageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 微信用户id
     * @return 微信用户信息
     */
    WechatUserVO getDetail(String id);

    /**
     * 根据id删除微信用户
     * @param id 微信用户id
     */
    void remove(String id);

    /**
     * 粉丝同步
     * @param appId 账号id
     */
    void syncFans(String appId);
}