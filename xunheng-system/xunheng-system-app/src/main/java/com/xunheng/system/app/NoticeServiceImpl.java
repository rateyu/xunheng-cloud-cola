package com.xunheng.system.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.api.NoticeService;
import com.xunheng.system.client.dto.query.NoticePageQuery;
import com.xunheng.system.client.dto.VO.NoticeVO;
import com.xunheng.system.app.executor.NoticeMarkReadAllCmdExe;
import com.xunheng.system.app.executor.NoticeMarkReadCmdExe;
import com.xunheng.system.app.executor.NoticeRemoveCmdExe;
import com.xunheng.system.app.executor.query.NoticeUnreadListQueryExe;
import com.xunheng.system.app.executor.query.NoticePageQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息通知service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticePageQueryExe noticePageQueryExe;

    @Resource
    private NoticeUnreadListQueryExe noticeUnreadListQueryExe;

    @Resource
    private NoticeRemoveCmdExe noticeRemoveCmdExe;

    @Resource
    private NoticeMarkReadCmdExe noticeMarkReadCmdExe;

    @Resource
    private NoticeMarkReadAllCmdExe noticeMarkReadAllCmdExe;

    @Override
    public IPage<NoticeVO> pageList(NoticePageQuery query) {
        return noticePageQueryExe.execute(query);
    }

    @Override
    public List<NoticeVO> getUnReadNoticeList() {
        return noticeUnreadListQueryExe.execute();
    }

    @Override
    public void markRead(String id) {
         noticeMarkReadCmdExe.execute(id);
    }

    @Override
    public void markReadAll() {
        noticeMarkReadAllCmdExe.execute();
    }

    @Override
    public void remove(String id) {
        noticeRemoveCmdExe.execute(id);
    }
}