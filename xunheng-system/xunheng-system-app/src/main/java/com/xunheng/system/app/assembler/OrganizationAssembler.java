package com.xunheng.system.app.assembler;

import com.xunheng.system.client.dto.OrganizationCreateCmd;
import com.xunheng.system.client.dto.OrganizationUpdateCmd;
import com.xunheng.system.client.dto.VO.OrganizationVO;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import io.seata.common.util.StringUtils;
import org.apache.poi.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:31
 */
public class OrganizationAssembler {

    public static OrganizationEntity toCreateEntity(OrganizationCreateCmd cmd) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setTitle(cmd.getTitle());
        entity.setParentId(cmd.getParentId());
        entity.setStatus(cmd.getStatus());
        entity.setType(cmd.getType());
        entity.setTenantId(cmd.getTenantId());
        entity.setSubCompanyId(cmd.getSubCompanyId());
        return entity;
    }


    public static OrganizationEntity toUpdateEntity(OrganizationUpdateCmd cmd) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId(cmd.getId());
        entity.setTitle(cmd.getTitle());
        entity.setParentId(cmd.getParentId());
        entity.setSortOrder(cmd.getSortOrder());
        entity.setStatus(cmd.getStatus());
        entity.setType(cmd.getType());
        entity.setSubCompanyId(cmd.getSubCompanyId());
        return entity;
    }

    public static OrganizationVO toVo(OrganizationEntity entity) {
        if(entity == null)return null;
        OrganizationVO vo = new OrganizationVO();
        vo.setId(entity.getId());
        vo.setTitle(entity.getTitle());
        vo.setParentId(entity.getParentId());
        vo.setSortOrder(entity.getSortOrder());
        vo.setStatus(entity.getStatus());
        vo.setType(entity.getType());
        vo.setTenantId(entity.getTenantId());
        vo.setSubCompanyId(entity.getSubCompanyId());
        return vo;
    }

    /**
     * 将列表转化为树形结构
     */
    public static List<OrganizationVO> toTree(List<OrganizationVO> treeList) {
        /*从当前列表中找到父节点*/
        List<String> treeIds = treeList.stream().map(OrganizationVO::getId).collect(Collectors.toList());
        List<OrganizationVO> parentOrgs = treeList.stream().filter(item -> !treeIds.contains(item.getParentId() == null ? "-1":item.getParentId())).collect(Collectors.toList());//拿到父节点
        /*遍历父节点进行递归操作*/
        parentOrgs.forEach(p -> p.setChildren(recursionList(p,treeList)));
        return parentOrgs;
    }

    private static List<OrganizationVO> recursionList(OrganizationVO parentOrg,List<OrganizationVO> treeList){
        return treeList.stream()
                // 筛选父节点
                .filter(t -> StringUtils.equals(parentOrg.getId(),t.getParentId()))
                // 递归设置子节点
                .map(item -> {
                    item.setChildren(recursionList(item, treeList));
                    item.setParentTitle(parentOrg.getTitle());
                    return item;
                })
                .collect(Collectors.toList());

    }
}
