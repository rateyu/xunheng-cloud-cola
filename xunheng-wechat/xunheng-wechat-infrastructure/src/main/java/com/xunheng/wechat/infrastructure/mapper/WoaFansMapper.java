package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaFans;
import com.xunheng.wechat.client.dto.query.WoaFansPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝数据层
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Repository
public interface WoaFansMapper extends BaseMapper<WoaFans> {

    /**
     * 获取公众号粉丝分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WoaFans> pageList(Page<WoaFans> page, @Param("qry") WoaFansPageQuery query);

}
