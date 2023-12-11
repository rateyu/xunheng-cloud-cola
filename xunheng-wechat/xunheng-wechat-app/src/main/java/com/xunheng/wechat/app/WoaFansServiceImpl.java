package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.app.executor.WoaFansSyncCmdExe;
import com.xunheng.wechat.client.api.WoaFansService;
import com.xunheng.wechat.client.dto.query.WoaFansPageQuery;
import com.xunheng.wechat.client.dto.VO.WoaFansVO;
import com.xunheng.wechat.app.executor.WoaFansRemoveCmdExe;
import com.xunheng.wechat.app.executor.query.WoaFansPageQueryExe;
import com.xunheng.wechat.app.executor.query.WoaFansDetailQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝service实现类
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Service
@GlobalTransactional
public class WoaFansServiceImpl implements WoaFansService {

    @Resource
    private WoaFansPageQueryExe woaFansPageQueryExe;

    @Resource
    private WoaFansDetailQueryExe woaFansDetailQueryExe;

    @Resource
    private WoaFansRemoveCmdExe woaFansRemoveCmdExe;

    @Resource
    private WoaFansSyncCmdExe woaFansSyncCmdExe;

    @Override
    public IPage<WoaFansVO> pageList(WoaFansPageQuery query){
        return woaFansPageQueryExe.execute(query);
    }

    @Override
    public WoaFansVO getDetail(String id) {
        return woaFansDetailQueryExe.execute(id);
    }

    @Override
    public void remove(String id) {
        woaFansRemoveCmdExe.execute(id);
    }

    @Override
    public void syncFans(String appId) {
        woaFansSyncCmdExe.execute(appId);
    }

}