package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WechatUser;
import com.xunheng.wechat.client.dto.query.WechatUserPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户数据层
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Repository
public interface WechatUserMapper extends BaseMapper<WechatUser> {

    /**
     * 获取微信用户分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WechatUser> pageList(Page<WechatUser> page, @Param("qry") WechatUserPageQuery query);

}
