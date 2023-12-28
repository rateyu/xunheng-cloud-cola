package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.wechat.app.executor.query.WechatAccountSelectItemQueryExe;
import com.xunheng.wechat.client.api.WechatAccountService;
import com.xunheng.wechat.client.dto.VO.WxAccountSelectItemVO;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import com.xunheng.wechat.client.dto.WechatAccountCreateCmd;
import com.xunheng.wechat.client.dto.WechatAccountUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.app.executor.WechatAccountRemoveCmdExe;
import com.xunheng.wechat.app.executor.WechatAccountCreateCmdExe;
import com.xunheng.wechat.app.executor.WechatAccountUpdateCmdExe;
import com.xunheng.wechat.app.executor.query.WechatAccountPageQueryExe;
import com.xunheng.wechat.app.executor.query.WechatAccountDetailQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号service实现类
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Service
@GlobalTransactional
public class WechatAccountServiceImpl implements WechatAccountService {

    @Resource
    private WechatAccountPageQueryExe wechatAccountPageQueryExe;

    @Resource
    private WechatAccountDetailQueryExe wechatAccountDetailQueryExe;

    @Resource
    private WechatAccountCreateCmdExe wechatAccountCreateCmdExe;
    
    @Resource
    private WechatAccountUpdateCmdExe wechatAccountUpdateCmdExe;

    @Resource
    private WechatAccountRemoveCmdExe wechatAccountRemoveCmdExe;

    @Resource
    private WechatAccountSelectItemQueryExe wechatAccountSelectItemQueryExe;

    @Override
    public IPage<WechatAccountVO> pageList(WechatAccountPageQuery query){
        return wechatAccountPageQueryExe.execute(query);
    }

    @Override
    public WechatAccountVO getDetail(String id) {
        return wechatAccountDetailQueryExe.execute(id);
    }

    @Override
    public WechatAccountVO create(WechatAccountCreateCmd cmd) {
        return wechatAccountCreateCmdExe.execute(cmd);
    }

    @Override
    public WechatAccountVO update(WechatAccountUpdateCmd cmd) {
        return wechatAccountUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        wechatAccountRemoveCmdExe.execute(id);
    }

    @Override
    public List<WxAccountSelectItemVO> getSelectItem() {
        return wechatAccountSelectItemQueryExe.execute();
    }

}