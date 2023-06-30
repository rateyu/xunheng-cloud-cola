package com.xunheng.system.app.assembler;

import com.xunheng.base.vo.system.MetaVO;
import com.xunheng.base.vo.system.PermissionActionVO;
import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.system.client.dto.PermissionCreateCmd;
import com.xunheng.system.client.dto.PermissionUpdateCmd;
import com.xunheng.system.client.dto.VO.OrganizationVO;
import com.xunheng.system.domain.permission.model.PermissionEntity;
import io.seata.common.util.StringUtils;
import org.apache.poi.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:34
 */
public class PermissionAssembler {

    public static PermissionEntity toCreateEntity(PermissionCreateCmd cmd) {
        PermissionEntity entity = new PermissionEntity();
        entity.setName(cmd.getName());
        entity.setParentId(cmd.getParentId());
        entity.setStatus(cmd.getStatus());
        entity.setPath(cmd.getPath());
        entity.setComponent(cmd.getComponent());
        /*meta信息放到实体里*/
        entity.setTitle(cmd.getMeta().getTitle());
        entity.setType(cmd.getMeta().getType());
        entity.setIcon(cmd.getMeta().getIcon());
        entity.setFullpage(cmd.getMeta().getFullpage());
        return entity;
    }


    public static PermissionEntity toUpdateEntity(PermissionUpdateCmd cmd) {
        PermissionEntity entity = new PermissionEntity();
        entity.setId(cmd.getId());
        entity.setName(cmd.getName());
        entity.setParentId(cmd.getParentId());
        entity.setStatus(cmd.getStatus());
        entity.setPath(cmd.getPath());
        entity.setComponent(cmd.getComponent());
        entity.setSortOrder(cmd.getSortOrder());
        entity.setTitle(cmd.getMeta().getTitle());
        entity.setType(cmd.getMeta().getType());
        entity.setIcon(cmd.getMeta().getIcon());
        entity.setFullpage(cmd.getMeta().getFullpage());
        return entity;
    }

    public static PermissionVO toVo(PermissionEntity entity) {
        if(entity == null)return null;
        PermissionVO vo = new PermissionVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setPath(entity.getPath());
        vo.setComponent(entity.getComponent());
        vo.setParentId(entity.getParentId());
        vo.setSortOrder(entity.getSortOrder());
        vo.setStatus(entity.getStatus());
        /*转换为meta信息*/
        vo.setMeta(new MetaVO(entity.getTitle(),entity.getIcon(),entity.getType(),entity.getFullpage()));
        if(entity.getActionList() != null){
            vo.setActionList(entity.getActionList().stream().map(PermissionActionAssembler::toVo).collect(Collectors.toList()));
        }else{
            vo.setActionList(new ArrayList<>());
        }
        return vo;
    }

    /**
     * 将权限列表转换为树形结构
     */
    public static List<PermissionVO> toTree(List<PermissionVO> treeList) {
        /*先找到父节点*/
        List<String> treeIds = treeList.stream().map(PermissionVO::getId).collect(Collectors.toList());
        List<PermissionVO> parentPers = treeList.stream().filter(item -> !treeIds.contains(item.getParentId() == null ? "-1":item.getParentId())).collect(Collectors.toList());//拿到父节点
        /*遍历父节点进行递归操作*/
        parentPers.forEach(p -> p.setChildren(recursionList(p,treeList)));
        return parentPers;
    }

    private static List<PermissionVO> recursionList(PermissionVO parentPer,List<PermissionVO> treeList){
        return treeList.stream()
                // 筛选父节点
                .filter(t -> StringUtils.equals(parentPer.getId(),t.getParentId()))
                // 递归设置子节点
                .map(item -> {
                    item.setChildren(recursionList(item, treeList));
                    return item;
                })
                .collect(Collectors.toList());

    }

}
