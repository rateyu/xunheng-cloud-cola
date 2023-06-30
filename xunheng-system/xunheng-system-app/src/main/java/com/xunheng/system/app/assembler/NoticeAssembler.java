package com.xunheng.system.app.assembler;

import com.xunheng.system.client.dto.VO.NoticeVO;
import com.xunheng.system.domain.notice.model.NoticeEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息通知dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:31
 */
public class NoticeAssembler {

    public static NoticeVO toVo(NoticeEntity entity) {
        if(entity == null)return null;
        NoticeVO vo = new NoticeVO();
        vo.setId(entity.getId());
        vo.setTitle(entity.getTitle());
        vo.setDescription(entity.getDescription());
        vo.setContent(entity.getContent());
        vo.setIsPub(entity.getIsPub());
        vo.setUserId(entity.getUserId());
        vo.setType(entity.getType());
        vo.setTimeStr(entity.getTimeStr());
        vo.setReadFlag(entity.getReadFlag());
        return vo;
    }
}
