package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.wechat.app.assembler.WechatAccountAssembler;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import com.xunheng.wechat.domain.wechatAccount.gateway.WechatAccountGateway;
import com.xunheng.wechat.domain.wechatAccount.model.WechatAccountEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号可选择项查询处理器
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Component
public class WechatAccountSelectItemQueryExe {

    @Resource
    WechatAccountGateway wechatAccountGateway;

    public List<SelectItemVO> execute() {
        List<WechatAccountEntity> list = wechatAccountGateway.allList();
        return list.stream().
                map(item ->{
                    SelectItemVO vo = new SelectItemVO();
                    vo.setId(item.getAppId());
                    vo.setTitle(item.getName());
                    vo.setValue(item.getAppId());
                    return vo;
                }).collect(Collectors.toList());
    }
}
