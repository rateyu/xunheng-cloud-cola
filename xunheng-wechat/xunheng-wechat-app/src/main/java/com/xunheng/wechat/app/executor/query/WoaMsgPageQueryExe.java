package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.app.assembler.WoaMsgAssembler;
import com.xunheng.wechat.client.dto.query.WoaMsgPageQuery;
import com.xunheng.wechat.client.dto.VO.WoaMsgVO;
import com.xunheng.wechat.domain.customerService.gateway.WoaMsgGateway;
import com.xunheng.wechat.domain.customerService.model.WoaMsgEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
@Component
public class WoaMsgPageQueryExe {

    @Resource
    WoaMsgGateway woaMsgGateway;

    public IPage<WoaMsgVO> execute(WoaMsgPageQuery query) {
        if(StringUtils.isEmpty(query.getAppId())) return new Page<>();
        IPage<WoaMsgEntity> page = woaMsgGateway.pageList(query);
        return page.convert(WoaMsgAssembler::toVo);
    }
}
