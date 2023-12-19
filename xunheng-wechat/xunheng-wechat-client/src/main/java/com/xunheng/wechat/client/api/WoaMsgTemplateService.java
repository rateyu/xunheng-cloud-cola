package com.xunheng.wechat.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.VO.WoaMsgTemplateVO;
import com.xunheng.wechat.client.dto.query.WoaMsgTemplatePageQuery;
import com.xunheng.wechat.client.dto.WoaMsgTemplateCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgTemplateUpdateCmd;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板service
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
public interface WoaMsgTemplateService{

    /**
     * 消息推送模板分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaMsgTemplateVO> pageList(WoaMsgTemplatePageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 消息推送模板id
     * @return 消息推送模板信息
     */
    WoaMsgTemplateVO getDetail(String id);

    /**
     * 创建消息推送模板信息
     * @param cmd 创建操作cmd
     * @return 消息推送模板信息
     */
    WoaMsgTemplateVO create(WoaMsgTemplateCreateCmd cmd);

    /**
     * 更新消息推送模板信息
     * @param cmd 更新操作cmd
     * @return 消息推送模板信息
     */
    WoaMsgTemplateVO update(WoaMsgTemplateUpdateCmd cmd);

    /**
     * 根据id删除消息推送模板
     * @param id 消息推送模板id
     */
    void remove(String id);

    /**
     * 同步消息推送模板
     * @param appId appId
     */
    void sync(String appId);
}