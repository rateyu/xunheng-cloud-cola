package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.app.executor.WoaFansSyncCmdExe;
import com.xunheng.wechat.client.api.WechatUserService;
import com.xunheng.wechat.client.dto.query.WechatUserPageQuery;
import com.xunheng.wechat.client.dto.VO.WechatUserVO;
import com.xunheng.wechat.app.executor.WechatUserRemoveCmdExe;
import com.xunheng.wechat.app.executor.query.WechatUserPageQueryExe;
import com.xunheng.wechat.app.executor.query.WechatUserDetailQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户service实现类
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Service
@GlobalTransactional
public class WechatUserServiceImpl implements WechatUserService {

    @Resource
    private WechatUserPageQueryExe wechatUserPageQueryExe;

    @Resource
    private WechatUserDetailQueryExe wechatUserDetailQueryExe;

    @Resource
    private WechatUserRemoveCmdExe wechatUserRemoveCmdExe;

    @Resource
    private WoaFansSyncCmdExe woaFansSyncCmdExe;

    @Override
    public IPage<WechatUserVO> pageList(WechatUserPageQuery query){
        return wechatUserPageQueryExe.execute(query);
    }

    @Override
    public WechatUserVO getDetail(String id) {
        return wechatUserDetailQueryExe.execute(id);
    }

    @Override
    public void remove(String id) {
        wechatUserRemoveCmdExe.execute(id);
    }

    @Override
    public void syncFans(String appId) {
        woaFansSyncCmdExe.execute(appId);
    }

}