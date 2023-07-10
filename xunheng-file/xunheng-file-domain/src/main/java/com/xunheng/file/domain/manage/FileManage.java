package com.xunheng.file.domain.manage;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileManage {

    /**
     * 文件流上传
     * @param inputStream 输入流
     * @param file 文件本身
     * @param key 文件key
     * @param fullDir 文件上传路径
     * @return 上传成功后文件路径
     */
    String inputStreamUpload(InputStream inputStream,MultipartFile file,String key,String fullDir);

    /**
     * 重命名文件
     * @param url 源文件路径
     * @param toKey 新名
     * @return 重命名后新路径
     */
    String renameFile(String url, String toKey);

    /**
     * 拷贝文件
     * @param url 源文件路径
     * @param toKey 新路径
     * @return 拷贝后新路径
     */
    String copyFile(String url, String toKey);

    /**
     * 删除文件
     * @param key 文件key
     */
    void deleteFile(String key);
}
