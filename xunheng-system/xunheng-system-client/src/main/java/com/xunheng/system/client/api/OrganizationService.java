package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.OrganizationCreateCmd;
import com.xunheng.system.client.dto.OrganizationUpdateCmd;
import com.xunheng.system.client.dto.VO.OrganizationVO;
import com.xunheng.system.client.dto.query.OrganizationListQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:16
 */
public interface OrganizationService {

    /**
     * 获取组织架构列表
     * @param query 查询dto
     * @return 树形列表
     */
    List<OrganizationVO> getGroupOrganizationList(OrganizationListQuery query);

    /**
     * 新增组织架构
     * @param cmd 保存操作dto
     * @return 组织架构信息
     */
    OrganizationVO create(OrganizationCreateCmd cmd);

    /**
     * 更新组织架构
     * @param cmd 保存操作dto
     * @return 组织架构信息
     */
    OrganizationVO update(OrganizationUpdateCmd cmd);

    /**
     * 删除
     * @param id 组织架构id
     */
    void remove(String id);

}
