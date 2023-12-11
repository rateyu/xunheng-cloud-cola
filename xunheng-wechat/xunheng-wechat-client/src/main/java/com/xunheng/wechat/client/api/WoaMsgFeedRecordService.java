package com.xunheng.wechat.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.VO.WoaMsgFeedRecordVO;
import com.xunheng.wechat.client.dto.query.WoaMsgFeedRecordPageQuery;
import com.xunheng.wechat.client.dto.WoaMsgFeedRecordCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgFeedRecordUpdateCmd;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志service
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
public interface WoaMsgFeedRecordService{

    /**
     * 消息推送日志分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaMsgFeedRecordVO> pageList(WoaMsgFeedRecordPageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 消息推送日志id
     * @return 消息推送日志信息
     */
    WoaMsgFeedRecordVO getDetail(String id);

    /**
     * 创建消息推送日志信息
     * @param cmd 创建操作cmd
     * @return 消息推送日志信息
     */
    WoaMsgFeedRecordVO create(WoaMsgFeedRecordCreateCmd cmd);

    /**
     * 更新消息推送日志信息
     * @param cmd 更新操作cmd
     * @return 消息推送日志信息
     */
    WoaMsgFeedRecordVO update(WoaMsgFeedRecordUpdateCmd cmd);

    /**
     * 根据id删除消息推送日志
     * @param id 消息推送日志id
     */
    void remove(String id);

}