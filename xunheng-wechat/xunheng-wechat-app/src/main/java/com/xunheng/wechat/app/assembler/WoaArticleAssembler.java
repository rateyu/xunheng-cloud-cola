package com.xunheng.wechat.app.assembler;

import com.xunheng.wechat.client.dto.WoaArticleSaveCmd;
import com.xunheng.wechat.client.dto.VO.WoaArticleVO;
import com.xunheng.wechat.domain.article.model.WoaArticleEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章dto转换
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
public class WoaArticleAssembler {

    public static WoaArticleEntity toSaveEntity(WoaArticleSaveCmd cmd) {
        if(cmd == null)return null;
        WoaArticleEntity entity = new WoaArticleEntity();
        entity.setId(cmd.getId());
        entity.setType(cmd.getType());
        entity.setTitle(cmd.getTitle());
        entity.setTags(cmd.getTags());
        entity.setSummary(cmd.getSummary());
        entity.setContent(cmd.getContent());
        entity.setCategory(cmd.getCategory());
        entity.setSubCategory(cmd.getSubCategory());
        entity.setOpenCount(cmd.getOpenCount());
        entity.setTargetLink(cmd.getTargetLink());
        entity.setImage(cmd.getImage());
        return entity;
    }

    public static WoaArticleVO toVo(WoaArticleEntity entity) {
        if(entity == null)return null;
        WoaArticleVO vo = new WoaArticleVO();
        vo.setId(entity.getId());
        vo.setType(entity.getType());
        vo.setTitle(entity.getTitle());
        vo.setTags(entity.getTags());
        vo.setSummary(entity.getSummary());
        vo.setContent(entity.getContent());
        vo.setCategory(entity.getCategory());
        vo.setSubCategory(entity.getSubCategory());
        vo.setOpenCount(entity.getOpenCount());
        vo.setTargetLink(entity.getTargetLink());
        vo.setImage(entity.getImage());
        return vo;
    }
}
