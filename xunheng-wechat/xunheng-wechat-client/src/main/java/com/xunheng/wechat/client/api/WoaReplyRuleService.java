package com.xunheng.wechat.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.VO.WoaReplyRuleVO;
import com.xunheng.wechat.client.dto.query.WoaReplyRulePageQuery;
import com.xunheng.wechat.client.dto.WoaReplyRuleCreateCmd;
import com.xunheng.wechat.client.dto.WoaReplyRuleUpdateCmd;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则service
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
public interface WoaReplyRuleService{

    /**
     * 公众号回复规则分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaReplyRuleVO> pageList(WoaReplyRulePageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 公众号回复规则id
     * @return 公众号回复规则信息
     */
    WoaReplyRuleVO getDetail(String id);

    /**
     * 创建公众号回复规则信息
     * @param cmd 创建操作cmd
     * @return 公众号回复规则信息
     */
    WoaReplyRuleVO create(WoaReplyRuleCreateCmd cmd);

    /**
     * 更新公众号回复规则信息
     * @param cmd 更新操作cmd
     * @return 公众号回复规则信息
     */
    WoaReplyRuleVO update(WoaReplyRuleUpdateCmd cmd);

    /**
     * 根据id删除公众号回复规则
     * @param id 公众号回复规则id
     */
    void remove(String id);

}