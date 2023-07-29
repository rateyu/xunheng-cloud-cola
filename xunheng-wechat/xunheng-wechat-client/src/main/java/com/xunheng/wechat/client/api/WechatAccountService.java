package com.xunheng.wechat.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import com.xunheng.wechat.client.dto.WechatAccountCreateCmd;
import com.xunheng.wechat.client.dto.WechatAccountUpdateCmd;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号service
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
public interface WechatAccountService{

    /**
     * 微信开发帐号分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WechatAccountVO> pageList(WechatAccountPageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 微信开发帐号id
     * @return 微信开发帐号信息
     */
    WechatAccountVO getDetail(String id);

    /**
     * 创建微信开发帐号信息
     * @param cmd 创建操作cmd
     * @return 微信开发帐号信息
     */
    WechatAccountVO create(WechatAccountCreateCmd cmd);

    /**
     * 更新微信开发帐号信息
     * @param cmd 更新操作cmd
     * @return 微信开发帐号信息
     */
    WechatAccountVO update(WechatAccountUpdateCmd cmd);

    /**
     * 根据id删除微信开发帐号
     * @param id 微信开发帐号id
     */
    void remove(String id);

    /**
     * 获取可选择项
     * @return 帐号列表
     */
    List<SelectItemVO> getSelectItem();
}