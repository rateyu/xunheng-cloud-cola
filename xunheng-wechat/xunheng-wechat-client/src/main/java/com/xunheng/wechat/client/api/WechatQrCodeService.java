package com.xunheng.wechat.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.VO.WechatQrCodeVO;
import com.xunheng.wechat.client.dto.query.WechatQrCodePageQuery;
import com.xunheng.wechat.client.dto.WechatQrCodeCreateCmd;
import com.xunheng.wechat.client.dto.WechatQrCodeUpdateCmd;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息service
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
public interface WechatQrCodeService{

    /**
     * 账号二维码信息分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WechatQrCodeVO> pageList(WechatQrCodePageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 账号二维码信息id
     * @return 账号二维码信息信息
     */
    WechatQrCodeVO getDetail(String id);

    /**
     * 创建账号二维码信息信息
     * @param cmd 创建操作cmd
     * @return 账号二维码信息信息
     */
    WechatQrCodeVO create(WechatQrCodeCreateCmd cmd);

    /**
     * 更新账号二维码信息信息
     * @param cmd 更新操作cmd
     * @return 账号二维码信息信息
     */
    WechatQrCodeVO update(WechatQrCodeUpdateCmd cmd);

    /**
     * 根据id删除账号二维码信息
     * @param id 账号二维码信息id
     */
    void remove(String id);

}