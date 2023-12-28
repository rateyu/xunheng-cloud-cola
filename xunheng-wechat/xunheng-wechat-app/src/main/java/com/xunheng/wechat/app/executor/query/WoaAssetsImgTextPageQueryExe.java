package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.client.dto.query.WoaImgTextPageQuery;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNewsBatchGetResult;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号图文素材分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaAssetsImgTextPageQueryExe {

    @Resource
    private WxMpService wxMpService;

    public WxMpMaterialNewsBatchGetResult execute(WoaImgTextPageQuery query) {
        try {
            log.info("从API获取媒体素材列表,page={}",query.getPage());
            wxMpService.switchoverTo(query.getAppId());
            final int pageSize = query.getPageSize();
            int offset=(query.getPage()-1)*pageSize;
            return wxMpService.getMaterialService().materialNewsBatchGet(offset, pageSize);
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }
}
