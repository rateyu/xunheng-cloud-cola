package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WechatQrCode;
import com.xunheng.wechat.client.dto.query.WechatQrCodePageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息数据层
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Repository
public interface WechatQrCodeMapper extends BaseMapper<WechatQrCode> {

    /**
     * 获取账号二维码信息分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WechatQrCode> pageList(Page<WechatQrCode> page, @Param("qry") WechatQrCodePageQuery query);

}
