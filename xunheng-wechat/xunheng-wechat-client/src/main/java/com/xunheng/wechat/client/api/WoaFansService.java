package com.xunheng.wechat.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.VO.WoaFansVO;
import com.xunheng.wechat.client.dto.query.WoaFansPageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝service
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
public interface WoaFansService{

    /**
     * 公众号粉丝分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaFansVO> pageList(WoaFansPageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 公众号粉丝id
     * @return 公众号粉丝信息
     */
    WoaFansVO getDetail(String id);

    /**
     * 根据id删除公众号粉丝
     * @param id 公众号粉丝id
     */
    void remove(String id);

    /**
     * 粉丝同步
     * @param appId 账号id
     */
    void syncFans(String appId);
}