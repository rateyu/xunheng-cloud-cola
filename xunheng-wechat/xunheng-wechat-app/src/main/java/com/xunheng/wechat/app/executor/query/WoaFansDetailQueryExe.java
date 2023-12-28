package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WoaFansAssembler;
import com.xunheng.wechat.client.dto.VO.WoaFansVO;
import com.xunheng.wechat.domain.fans.gateway.WoaFansGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Component
public class WoaFansDetailQueryExe {
    @Resource
    WoaFansGateway woaFansGateway;

    public WoaFansVO execute(String id) {
        return WoaFansAssembler.toVo(woaFansGateway.getOneById(id));
    }
}

