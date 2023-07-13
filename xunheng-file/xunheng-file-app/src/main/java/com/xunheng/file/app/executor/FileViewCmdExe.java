package com.xunheng.file.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.file.domain.file.gateway.FileGateway;
import com.xunheng.file.domain.file.model.FileEntity;
import com.xunheng.file.domain.manage.impl.LocalFileManage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @program: xunheng-cloud-cola
 * @description: 本地文件查看操作处理器
 * @author: hhqkkr
 * @date: 2023/7/10 16:13
 */
@Component
public class FileViewCmdExe {

    @Resource
    private FileGateway fileGateway;

    public void execute(String id, HttpServletResponse response) {
        try {
            FileEntity file = fileGateway.getOne(id);
            if (file == null)throw new GlobalException("文件ID：" + id + "不存在");
            String fKey = file.getFKey();
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fKey, "UTF-8"));
            response.setContentLengthLong(file.getSize());
            response.setContentType(file.getType() + ";charset=UTF-8");
            response.addHeader("Accept-Ranges", "bytes");
            if (file.getSize() != null && file.getSize() > 0) {
                response.addHeader("Content-Range", "bytes " + 0 + "-" + (file.getSize() - 1) + "/" + file.getSize());
            }
            response.setBufferSize(10 * 1024 * 1024);
            LocalFileManage.view(file.getUrl(), response);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
