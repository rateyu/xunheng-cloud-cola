package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.app.assembler.WechatQrCodeAssembler;
import com.xunheng.wechat.client.dto.query.WechatQrCodePageQuery;
import com.xunheng.wechat.client.dto.VO.WechatQrCodeVO;
import com.xunheng.wechat.domain.account.gateway.WechatQrCodeGateway;
import com.xunheng.wechat.domain.account.model.WechatQrCodeEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Component
public class WechatQrCodePageQueryExe {

    @Resource
    WechatQrCodeGateway wechatQrCodeGateway;

    public IPage<WechatQrCodeVO> execute(WechatQrCodePageQuery query) {
        if(StringUtils.isEmpty(query.getAppId())) return new Page<>();
        IPage<WechatQrCodeEntity> page = wechatQrCodeGateway.pageList(query);
        return page.convert(WechatQrCodeAssembler::toVo);
    }
}
