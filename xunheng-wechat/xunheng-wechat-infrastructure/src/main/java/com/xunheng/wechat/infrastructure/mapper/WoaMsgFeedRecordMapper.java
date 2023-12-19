package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaMsgFeedRecord;
import com.xunheng.wechat.client.dto.query.WoaMsgFeedRecordPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志数据层
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
@Repository
public interface WoaMsgFeedRecordMapper extends BaseMapper<WoaMsgFeedRecord> {

    /**
     * 获取消息推送日志分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WoaMsgFeedRecord> pageList(Page<WoaMsgFeedRecord> page, @Param("qry") WoaMsgFeedRecordPageQuery query);

}
