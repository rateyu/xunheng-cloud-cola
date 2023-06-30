package com.xunheng.system.app.executor.query;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.system.app.assembler.NoticeAssembler;
import com.xunheng.system.client.dto.VO.NoticeVO;
import com.xunheng.system.domain.notice.gateway.NoticeGateway;
import com.xunheng.system.domain.notice.model.NoticeEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息未读列表查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:50
 */
@Component
public class NoticeUnreadListQueryExe {

    @Resource
    NoticeGateway noticeGateway;

    public List<NoticeVO> execute() {
        List<NoticeEntity> list = noticeGateway.getUnReadNoticeList(StpUtil.getLoginId("-1"));
        return list.stream().map(NoticeAssembler::toVo).collect(Collectors.toList());
    }
}
