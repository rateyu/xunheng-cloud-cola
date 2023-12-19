package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.app.executor.WoaMsgTemplateSyncCmdExe;
import com.xunheng.wechat.client.api.WoaMsgTemplateService;
import com.xunheng.wechat.client.dto.query.WoaMsgTemplatePageQuery;
import com.xunheng.wechat.client.dto.WoaMsgTemplateCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgTemplateUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgTemplateVO;
import com.xunheng.wechat.app.executor.WoaMsgTemplateRemoveCmdExe;
import com.xunheng.wechat.app.executor.WoaMsgTemplateCreateCmdExe;
import com.xunheng.wechat.app.executor.WoaMsgTemplateUpdateCmdExe;
import com.xunheng.wechat.app.executor.query.WoaMsgTemplatePageQueryExe;
import com.xunheng.wechat.app.executor.query.WoaMsgTemplateDetailQueryExe;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板service实现类
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Service
@GlobalTransactional
public class WoaMsgTemplateServiceImpl implements WoaMsgTemplateService {

    @Resource
    private WoaMsgTemplatePageQueryExe woaMsgTemplatePageQueryExe;

    @Resource
    private WoaMsgTemplateDetailQueryExe woaMsgTemplateDetailQueryExe;

    @Resource
    private WoaMsgTemplateCreateCmdExe woaMsgTemplateCreateCmdExe;
    
    @Resource
    private WoaMsgTemplateUpdateCmdExe woaMsgTemplateUpdateCmdExe;

    @Resource
    private WoaMsgTemplateRemoveCmdExe woaMsgTemplateRemoveCmdExe;

    @Resource
    private WoaMsgTemplateSyncCmdExe woaMsgTemplateSyncCmdExe;

    @Override
    public IPage<WoaMsgTemplateVO> pageList(WoaMsgTemplatePageQuery query){
        return woaMsgTemplatePageQueryExe.execute(query);
    }

    @Override
    public WoaMsgTemplateVO getDetail(String id) {
        return woaMsgTemplateDetailQueryExe.execute(id);
    }

    @Override
    public WoaMsgTemplateVO create(WoaMsgTemplateCreateCmd cmd) {
        return woaMsgTemplateCreateCmdExe.execute(cmd);
    }

    @Override
    public WoaMsgTemplateVO update(WoaMsgTemplateUpdateCmd cmd) {
        return woaMsgTemplateUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        woaMsgTemplateRemoveCmdExe.execute(id);
    }

    @Override
    public void sync(String appId) {
            woaMsgTemplateSyncCmdExe.execute(appId);
    }

}