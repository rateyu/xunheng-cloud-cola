package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaReplyRule;
import com.xunheng.wechat.client.dto.query.WoaReplyRulePageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则数据层
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Repository
public interface WoaReplyRuleMapper extends BaseMapper<WoaReplyRule> {

    /**
     * 获取公众号回复规则分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WoaReplyRule> pageList(Page<WoaReplyRule> page, @Param("qry") WoaReplyRulePageQuery query);

}
