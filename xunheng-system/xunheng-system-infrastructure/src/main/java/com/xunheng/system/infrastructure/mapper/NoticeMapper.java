package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.Notice;
import com.xunheng.system.client.dto.query.NoticePageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统信息数据处理层
 * @author hhqkkr
 * @date 2022-04-29 12:11:49
 */
@Repository
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 消息通知分页列表
     * @param page 分页信息
     * @param query 查询条件
     * @return 分页列表
     */
    IPage<Notice> pageList(Page<Notice> page, @Param("qry") NoticePageQuery query);

    /**
     * 未读消息列表
     * @param userId 用户id
     * @return 消息列表
     */
    List<Notice> getUnReadNoticeList(@Param("userId")String userId);

}