package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaMsgTemplate;
import com.xunheng.wechat.client.dto.query.WoaMsgTemplatePageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板数据层
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Repository
public interface WoaMsgTemplateMapper extends BaseMapper<WoaMsgTemplate> {

    /**
     * 获取消息推送模板分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WoaMsgTemplate> pageList(Page<WoaMsgTemplate> page, @Param("qry") WoaMsgTemplatePageQuery query);

}
