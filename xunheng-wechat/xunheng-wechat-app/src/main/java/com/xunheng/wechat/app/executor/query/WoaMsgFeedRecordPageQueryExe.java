package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.app.assembler.WoaMsgFeedRecordAssembler;
import com.xunheng.wechat.client.dto.query.WoaMsgFeedRecordPageQuery;
import com.xunheng.wechat.client.dto.VO.WoaMsgFeedRecordVO;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgFeedRecordGateway;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgFeedRecordEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
@Component
public class WoaMsgFeedRecordPageQueryExe {

    @Resource
    WoaMsgFeedRecordGateway woaMsgFeedRecordGateway;

    public IPage<WoaMsgFeedRecordVO> execute(WoaMsgFeedRecordPageQuery query) {
        if(StringUtils.isEmpty(query.getAppId())) return new Page<>();
        IPage<WoaMsgFeedRecordEntity> page = woaMsgFeedRecordGateway.pageList(query);
        return page.convert(WoaMsgFeedRecordAssembler::toVo);
    }
}
