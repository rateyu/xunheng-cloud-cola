package com.xunheng.file.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.file.app.executor.FileViewCmdExe;
import com.xunheng.file.app.executor.FileRemoveCmdExe;
import com.xunheng.file.app.executor.FileUploadCmdExe;
import com.xunheng.file.app.executor.query.FilePageQueryExe;
import com.xunheng.file.client.api.FileService;
import com.xunheng.file.client.dto.FileUploadCmd;
import com.xunheng.file.client.dto.VO.FileUploadVO;
import com.xunheng.file.client.dto.VO.FileVO;
import com.xunheng.file.client.dto.query.FilePageQuery;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件service实现类
 * @author: hhqkkr
 * @date: 2023/7/10 15:39
 */
@Service
@GlobalTransactional
public class FileServiceImpl implements FileService {

    @Resource
    FilePageQueryExe filePageQueryExe;

    @Resource
    FileRemoveCmdExe fileRemoveCmdExe;

    @Resource
    FileUploadCmdExe fileUploadCmdExe;

    @Resource
    FileViewCmdExe fileViewCmdExe;


    @Override
    public IPage<FileVO> pageList(FilePageQuery query) {
        return filePageQueryExe.execute(query);
    }

    @Override
    public void remove(String id) {
        fileRemoveCmdExe.execute(id);
    }

    @Override
    public FileUploadVO upload(FileUploadCmd cmd) {
        return fileUploadCmdExe.execute(cmd);
    }

    @Override
    public void view(String id, HttpServletResponse response) {
        fileViewCmdExe.execute(id,response);
    }
}
