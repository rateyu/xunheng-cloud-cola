package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.api.WechatQrCodeService;
import com.xunheng.wechat.client.dto.query.WechatQrCodePageQuery;
import com.xunheng.wechat.client.dto.WechatQrCodeCreateCmd;
import com.xunheng.wechat.client.dto.WechatQrCodeUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WechatQrCodeVO;
import com.xunheng.wechat.app.executor.WechatQrCodeRemoveCmdExe;
import com.xunheng.wechat.app.executor.WechatQrCodeCreateCmdExe;
import com.xunheng.wechat.app.executor.WechatQrCodeUpdateCmdExe;
import com.xunheng.wechat.app.executor.query.WechatQrCodePageQueryExe;
import com.xunheng.wechat.app.executor.query.WechatQrCodeDetailQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息service实现类
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Service
@GlobalTransactional
public class WechatQrCodeServiceImpl implements WechatQrCodeService {

    @Resource
    private WechatQrCodePageQueryExe wechatQrCodePageQueryExe;

    @Resource
    private WechatQrCodeDetailQueryExe wechatQrCodeDetailQueryExe;

    @Resource
    private WechatQrCodeCreateCmdExe wechatQrCodeCreateCmdExe;
    
    @Resource
    private WechatQrCodeUpdateCmdExe wechatQrCodeUpdateCmdExe;

    @Resource
    private WechatQrCodeRemoveCmdExe wechatQrCodeRemoveCmdExe;

    @Override
    public IPage<WechatQrCodeVO> pageList(WechatQrCodePageQuery query){
        return wechatQrCodePageQueryExe.execute(query);
    }

    @Override
    public WechatQrCodeVO getDetail(String id) {
        return wechatQrCodeDetailQueryExe.execute(id);
    }

    @Override
    public WechatQrCodeVO create(WechatQrCodeCreateCmd cmd) {
        return wechatQrCodeCreateCmdExe.execute(cmd);
    }

    @Override
    public WechatQrCodeVO update(WechatQrCodeUpdateCmd cmd) {
        return wechatQrCodeUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        wechatQrCodeRemoveCmdExe.execute(id);
    }

}