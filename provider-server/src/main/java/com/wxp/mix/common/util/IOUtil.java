package com.wxp.mix.common.util;


import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @description: io工具类
 * @author: wxp
 * @time: 2022/4/9 9:27
 */
public class IOUtil {

    /**
     * 关闭连接资源
     * @param ios 连接资源列表
     * @throws IOException
     */
    public static void closeIO(Closeable ... ios) throws IOException {
        for (Closeable io : ios) {
            if(io != null){
                io.close();
            }
        }
    }

    /**
     * 获取目下的配置文件路径列表
     * @param dirPath 存放配置文件的目录
     * @return 文件列表
     */
    public static String[] getPropFiles(String dirPath) {
        File dir = new File(dirPath);
        String[] fileNames = dir.list();
        for (int i = 0; i < Objects.requireNonNull(fileNames).length; i++) {
            fileNames[i] = dirPath + "/" + fileNames[i];
        }
        return fileNames;
    }

}
