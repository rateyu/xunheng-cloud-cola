package com.xunheng.system.app.executor.query;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.app.assembler.NoticeAssembler;
import com.xunheng.system.client.dto.query.NoticePageQuery;
import com.xunheng.system.client.dto.VO.NoticeVO;
import com.xunheng.system.domain.notice.gateway.NoticeGateway;
import com.xunheng.system.domain.notice.model.NoticeEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息通知分页查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:49
 */
@Component
public class NoticePageQueryExe {
    @Resource
    NoticeGateway noticeGateway;

    public IPage<NoticeVO> execute(NoticePageQuery query) {
        query.setUserId(StpUtil.getLoginId(""));//将当前用户id放进参数
        IPage<NoticeEntity> page = noticeGateway.pageList(query);
        return page.convert(NoticeAssembler::toVo);
    }
}
