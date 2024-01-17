package com.xunheng.wechat.app.executor.query;

import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.wechat.client.dto.VO.WxAccountSelectItemVO;
import com.xunheng.wechat.domain.account.gateway.WechatAccountGateway;
import com.xunheng.wechat.domain.account.model.WechatAccountEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
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

    public List<WxAccountSelectItemVO> execute() {
        List<WechatAccountEntity> list = wechatAccountGateway.allList();
        return list.stream().
                map(item ->{
                    WxAccountSelectItemVO vo = new WxAccountSelectItemVO();
                    vo.setAppId(item.getAppId());
                    vo.setName(item.getName());
                    vo.setType(item.getType().getVal());
                    return vo;
                }).collect(Collectors.toList());
    }
}
