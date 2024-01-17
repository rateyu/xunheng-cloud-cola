package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.Notice;
import com.xunheng.system.infrastructure.convertor.NoticeConvertor;
import com.xunheng.system.client.dto.query.NoticePageQuery;
import com.xunheng.system.domain.notice.gateway.NoticeGateway;
import com.xunheng.system.infrastructure.mapper.NoticeMapper;
import com.xunheng.system.domain.notice.model.NoticeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息通知网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:33
 */
@Slf4j
@Component
public class NoticeGatewayImpl implements NoticeGateway {

    @Resource
    NoticeMapper noticeMapper;

    @Override
    public IPage<NoticeEntity> pageList(NoticePageQuery query) {
        IPage<Notice> page = noticeMapper.pageList(new Page<Notice>(query.getPage(), query.getPageSize()), query);
        return page.convert(NoticeConvertor::toEntity);
    }

    @Override
    public List<NoticeEntity> getUnReadNoticeList(String userId) {
        List<Notice> unReadNoticeList = noticeMapper.getUnReadNoticeList(userId);
        return unReadNoticeList.stream().map(NoticeConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public void remove(String id) {
        noticeMapper.deleteById(id);
    }
}
