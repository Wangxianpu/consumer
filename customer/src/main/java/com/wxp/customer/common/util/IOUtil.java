package com.wxp.customer.common.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @description: io工具类
 * @author: wxp
 * @time: 2022/4/9 9:27
 */
public class IOUtil {

    public static void closeIO(Closeable ... ios) throws IOException {
        for (Closeable io : ios) {
            if(io != null){
                io.close();
            }
        }
    }
}
