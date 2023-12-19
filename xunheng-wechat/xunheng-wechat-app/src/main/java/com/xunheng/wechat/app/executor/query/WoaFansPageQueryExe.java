package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.app.assembler.WoaFansAssembler;
import com.xunheng.wechat.client.dto.query.WoaFansPageQuery;
import com.xunheng.wechat.client.dto.VO.WoaFansVO;
import com.xunheng.wechat.domain.fans.gateway.WoaFansGateway;
import com.xunheng.wechat.domain.fans.model.WoaFansEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Component
public class WoaFansPageQueryExe {

    @Resource
    WoaFansGateway woaFansGateway;

    public IPage<WoaFansVO> execute(WoaFansPageQuery query) {
        if(StringUtils.isEmpty(query.getAppId())) return new Page<>();
        IPage<WoaFansEntity> page = woaFansGateway.pageList(query);
        return page.convert(WoaFansAssembler::toVo);
    }
}
