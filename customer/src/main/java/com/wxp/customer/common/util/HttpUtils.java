package com.wxp.customer.common.util;

import java.util.Map;

/**
 * @description: http工具类
 * @author: wxp
 * @time: 2022/4/7 21:54
 */
public class HttpUtils {


    /**
     * 拼接url, 传参为字符串
     * @param url 没有带参数的url
     * @param paramMap 传参
     * @return 完整的url
     */
    public static String getUrl(String url , Map<String,String> paramMap){
        StringBuilder sb = new StringBuilder(url);
        sb.append("?");
        for (String key: paramMap.keySet()) {
            sb.append(key).append("=").append(paramMap.get(key)).append("&");
        }
        return sb.substring(0,sb.length()-1);
    }
}
