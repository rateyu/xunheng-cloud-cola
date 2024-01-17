package com.xunheng.file.domain.manage.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.file.domain.manage.FileManage;
import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
@Component
public class LocalFileManage implements FileManage {

    //本地上传文件根目录
    @Value("${file.upload.rootLocalPath}")
    private String rootLocalPath;

    @Override
    public String inputStreamUpload(InputStream inputStream,MultipartFile file,String key,String fullDir){
        DateTime date = DateUtil.date();
        String finalDir = rootLocalPath + fullDir;
        String path =finalDir + "/" + date.year() + "/" + date.monthBaseOne() + "/" + date.dayOfMonth();
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File f = new File(path + "/" + key);
        if (f.exists()) {
            throw new GlobalException("文件名已存在");
        }
        try {
            file.transferTo(f);
            return path + "/" + key;
        } catch (IOException e) {
            log.error(e.toString());
            throw new GlobalException("上传文件出错");
        }
    }

    @Override
    public String renameFile(String url, String toKey) {
        File old = new File(url);
        FileUtil.rename(old, toKey, false, true);
        return old.getParentFile() + "/" + toKey;
    }

    @Override
    public String copyFile(String url, String toKey) {
        File file = new File(url);
        String newUrl = file.getParentFile() + "/" + toKey;
        FileUtil.copy(file, new File(newUrl), true);
        return newUrl;
    }

    /**
     * 注意此处需传入url
     * @param url
     */
    @Override
    public void deleteFile(String url) {
        FileUtil.del(new File(url));
    }

    /**
     * 读取文件
     * @param url
     * @param response
     */
    public static void view(String url, HttpServletResponse response) {

        File file = new File(url);
        if (!file.exists()) {
            throw new GlobalException("文件不存在");
        }

        try (FileInputStream is = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(is)) {

            OutputStream out = response.getOutputStream();
            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buf)) > 0) {
                out.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            log.error(e.toString());
            throw new GlobalException("读取/下载文件出错");
        }
    }
}
