package com.xunheng.file.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.file.client.dto.FileUploadCmd;
import com.xunheng.file.client.dto.VO.FileUploadVO;
import com.xunheng.file.client.dto.VO.FileVO;
import com.xunheng.file.client.dto.query.FilePageQuery;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件service
 * @author: hhqkkr
 * @date: 2023/7/10 14:02
 */
public interface FileService {

    /**
     * 文件分页列表
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<FileVO> pageList(FilePageQuery query);

    /**
     * 删除文件
     * @param id 文件id
     */
    void remove(String id);

    /**
     * 文件上传
     * @param cmd 文件上传操作dto
     * @return 文件上传结果vo
     */
    FileUploadVO upload(FileUploadCmd cmd);

    /**
     * 本地文件查看
     * @param id 文件id
     * @param response response
     */
    void view(String id, HttpServletResponse response);
}
