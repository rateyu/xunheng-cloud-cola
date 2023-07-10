package com.xunheng.file.app.assembler;

import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.file.client.dto.CatalogueSaveCmd;
import com.xunheng.file.client.dto.VO.CatalogueVO;
import com.xunheng.file.domain.catalogue.model.CatalogueEntity;
import io.seata.common.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传目录dto转换
 * @author: hhqkkr
 * @date: 2023/7/10 12:47
 */
public class CatalogueAssembler {

    public static CatalogueEntity toEntity(CatalogueSaveCmd cmd) {
        if(cmd == null)return null;
        CatalogueEntity entity = new CatalogueEntity();
        entity.setId(cmd.getId());
        entity.setTitle(cmd.getTitle());
        entity.setDir(cmd.getDir());
        entity.setStatus(cmd.getStatus());
        entity.setParentId(cmd.getParentId());
        entity.setSortOrder(cmd.getSortOrder());
        return entity;
    }

    public static CatalogueVO toVo(CatalogueEntity entity) {
        if(entity == null)return null;
        CatalogueVO vo = new CatalogueVO();
        vo.setId(entity.getId());
        vo.setTitle(entity.getTitle());
        vo.setDir(entity.getDir());
        vo.setStatus(entity.getStatus());
        vo.setParentId(entity.getParentId());
        vo.setSortOrder(entity.getSortOrder());
        return vo;
    }

    /**
     * 将列表转换为树形结构
     */
    public static List<CatalogueVO> toTree(List<CatalogueVO> treeList) {
        /*先找到父节点*/
        List<String> treeIds = treeList.stream().map(CatalogueVO::getId).collect(Collectors.toList());
        List<CatalogueVO> parentNodes = treeList.stream().filter(item -> !treeIds.contains(item.getParentId() == null ? "-1":item.getParentId())).collect(Collectors.toList());//拿到父节点
        /*遍历父节点进行递归操作 补充子数据*/
        parentNodes.forEach(p -> p.setChildren(recursionList(p,treeList)));
        return parentNodes;
    }

    private static List<CatalogueVO> recursionList(CatalogueVO parentPer,List<CatalogueVO> treeList){
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
