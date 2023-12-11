package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.app.assembler.WoaMsgTemplateAssembler;
import com.xunheng.wechat.client.dto.query.WoaMsgTemplatePageQuery;
import com.xunheng.wechat.client.dto.VO.WoaMsgTemplateVO;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgTemplateGateway;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgTemplateEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Component
public class WoaMsgTemplatePageQueryExe {

    @Resource
    WoaMsgTemplateGateway woaMsgTemplateGateway;

    public IPage<WoaMsgTemplateVO> execute(WoaMsgTemplatePageQuery query) {
        if(StringUtils.isEmpty(query.getAppId())) return new Page<>();
        IPage<WoaMsgTemplateEntity> page = woaMsgTemplateGateway.pageList(query);
        return page.convert(WoaMsgTemplateAssembler::toVo);
    }
}
