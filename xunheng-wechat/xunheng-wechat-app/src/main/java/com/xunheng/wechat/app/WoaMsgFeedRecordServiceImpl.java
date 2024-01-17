package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.api.WoaMsgFeedRecordService;
import com.xunheng.wechat.client.dto.query.WoaMsgFeedRecordPageQuery;
import com.xunheng.wechat.client.dto.WoaMsgFeedRecordCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgFeedRecordUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgFeedRecordVO;
import com.xunheng.wechat.app.executor.WoaMsgFeedRecordRemoveCmdExe;
import com.xunheng.wechat.app.executor.WoaMsgFeedRecordCreateCmdExe;
import com.xunheng.wechat.app.executor.WoaMsgFeedRecordUpdateCmdExe;
import com.xunheng.wechat.app.executor.query.WoaMsgFeedRecordPageQueryExe;
import com.xunheng.wechat.app.executor.query.WoaMsgFeedRecordDetailQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志service实现类
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
@Service
@GlobalTransactional
public class WoaMsgFeedRecordServiceImpl implements WoaMsgFeedRecordService {

    @Resource
    private WoaMsgFeedRecordPageQueryExe woaMsgFeedRecordPageQueryExe;

    @Resource
    private WoaMsgFeedRecordDetailQueryExe woaMsgFeedRecordDetailQueryExe;

    @Resource
    private WoaMsgFeedRecordCreateCmdExe woaMsgFeedRecordCreateCmdExe;
    
    @Resource
    private WoaMsgFeedRecordUpdateCmdExe woaMsgFeedRecordUpdateCmdExe;

    @Resource
    private WoaMsgFeedRecordRemoveCmdExe woaMsgFeedRecordRemoveCmdExe;

    @Override
    public IPage<WoaMsgFeedRecordVO> pageList(WoaMsgFeedRecordPageQuery query){
        return woaMsgFeedRecordPageQueryExe.execute(query);
    }

    @Override
    public WoaMsgFeedRecordVO getDetail(String id) {
        return woaMsgFeedRecordDetailQueryExe.execute(id);
    }

    @Override
    public WoaMsgFeedRecordVO create(WoaMsgFeedRecordCreateCmd cmd) {
        return woaMsgFeedRecordCreateCmdExe.execute(cmd);
    }

    @Override
    public WoaMsgFeedRecordVO update(WoaMsgFeedRecordUpdateCmd cmd) {
        return woaMsgFeedRecordUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        woaMsgFeedRecordRemoveCmdExe.execute(id);
    }

}