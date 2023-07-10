package com.xunheng.file.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.file.client.dto.UploadSettingSaveCmd;
import com.xunheng.file.client.dto.VO.UploadSettingVO;
import com.xunheng.file.client.dto.query.UploadSettingPageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置service
 * @author: hhqkkr
 * @date: 2023/7/10 12:32
 */
public interface UploadSettingService {

    /**
     * 上传设置分页
     * @param query 查询条件dto
     * @return 分页信息
     */
    IPage<UploadSettingVO> pageList(UploadSettingPageQuery query);

    /**
     * 插入或更新上传设置哦
     * @param cmd 保存操作dto
     * @return 上传信息
     */
    UploadSettingVO saveOrUpdate(UploadSettingSaveCmd cmd);

    /**
     * 删除上传设置
     * @param id 上传设置id
     */
    void remove(String id);
}
