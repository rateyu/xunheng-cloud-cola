package com.xunheng.base.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @program: xunheng-cloud-cola
 * @description:
 * @author: hhqkkr
 * @create: 2022-07-25 23:49
 */
public class FileUtil {

    public static String getStringByInputStream(InputStream inputStream){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[10240];
            int n;
            while ((n = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, n);
            }
        } catch (Exception e) {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception e1) {
            }
        }
        return outputStream.toString();
    }
}
