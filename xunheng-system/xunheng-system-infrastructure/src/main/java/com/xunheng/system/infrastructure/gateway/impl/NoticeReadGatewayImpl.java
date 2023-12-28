package com.xunheng.system.infrastructure.gateway.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.infrastructure.DO.NoticeRead;
import com.xunheng.system.domain.notice.gateway.NoticeReadGateway;
import com.xunheng.system.infrastructure.mapper.NoticeReadMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息通知已读标记网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:32
 */
@Slf4j
@Component
public class NoticeReadGatewayImpl implements NoticeReadGateway {

    @Resource
    NoticeReadMapper noticeReadMapper;

    @Override
    public void saveNoticeRead(String userId, String noticeId) {
        QueryWrapper<NoticeRead> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("notice_id",noticeId);
        NoticeRead one = noticeReadMapper.selectOne(wrapper);
        if(one == null){
            NoticeRead noticeRead = new NoticeRead();
            noticeRead.setNoticeId(noticeId);
            noticeRead.setUserId(StpUtil.getLoginId().toString());
            noticeReadMapper.insert(noticeRead);
        }
    }
}
