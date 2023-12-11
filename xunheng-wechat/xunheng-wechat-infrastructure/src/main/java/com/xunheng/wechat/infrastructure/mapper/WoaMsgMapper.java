package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaMsg;
import com.xunheng.wechat.client.dto.query.WoaMsgPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息数据层
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
@Repository
public interface WoaMsgMapper extends BaseMapper<WoaMsg> {

    /**
     * 获取公众号消息分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WoaMsg> pageList(Page<WoaMsg> page, @Param("qry") WoaMsgPageQuery query);

}
