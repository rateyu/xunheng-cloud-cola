package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WechatAccount;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号数据层
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Repository
public interface WechatAccountMapper extends BaseMapper<WechatAccount> {

    /**
     * 获取微信开发帐号分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WechatAccount> pageList(Page<WechatAccount> page, @Param("qry") WechatAccountPageQuery query);

}
