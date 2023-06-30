package com.xunheng.system.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.dto.TenantAuthRecordSaveCmd;
import com.xunheng.system.client.dto.VO.TenantAuthRecordVO;
import com.xunheng.system.client.dto.query.TenantAuthRecordPageQuery;

/**
 * 租户授权记录service
 * @author hhqkkr
 */
/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:24
 */ 
public interface TenantAuthRecordService {

    /**
     * 授权记录分页
     * @param query 查询dto
     * @return 分页信息
     */
    IPage<TenantAuthRecordVO> pageList(TenantAuthRecordPageQuery query);

    /**
     * 获取详情
     * @param id 记录id
     * @return 授权记录vo
     */
    TenantAuthRecordVO getDetail(String id);

    /**
     * 保存或更新授权记录
     * @param cmd 保存操作dto
     * @return 授权记录vo
     */
    TenantAuthRecordVO saveOrUpdate(TenantAuthRecordSaveCmd cmd);

    /**
     * 删除
     * @param id 记录id
     */
    void remove(String id);



}