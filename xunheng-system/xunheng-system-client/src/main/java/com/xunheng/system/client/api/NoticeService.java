package com.xunheng.system.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.dto.VO.NoticeVO;
import com.xunheng.system.client.dto.query.NoticePageQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息通知service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:14
 */
public interface NoticeService {

    /**
     * 消息删除
     * @param id 消息id
     */
    void remove(String id);

    /**
     * 标记全部已读
     */
    void markReadAll();

    /**
     * 标记已读
     * @param id 消息id
     */
    void markRead(String id);

    /**
     * 消息分页列表
     * @param query 查询dto
     * @return 分页信息
     */
    IPage<NoticeVO> pageList(NoticePageQuery query);

    /**
     * 未读消息列表
     * @return 消息列表
     */
    List<NoticeVO> getUnReadNoticeList();
}