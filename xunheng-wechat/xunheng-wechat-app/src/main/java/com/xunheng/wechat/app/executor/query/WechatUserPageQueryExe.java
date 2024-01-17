package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.app.assembler.WechatUserAssembler;
import com.xunheng.wechat.client.dto.query.WechatUserPageQuery;
import com.xunheng.wechat.client.dto.VO.WechatUserVO;
import com.xunheng.wechat.domain.wechatUser.gateway.WechatUserGateway;
import com.xunheng.wechat.domain.wechatUser.model.WechatUserEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Component
public class WechatUserPageQueryExe {

    @Resource
    WechatUserGateway wechatUserGateway;

    public IPage<WechatUserVO> execute(WechatUserPageQuery query) {
        if(StringUtils.isEmpty(query.getAppId())) return new Page<>();
        IPage<WechatUserEntity> page = wechatUserGateway.pageList(query);
        return page.convert(WechatUserAssembler::toVo);
    }
}
