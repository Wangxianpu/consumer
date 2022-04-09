package com.wxp.mix.common.constant;

import com.google.gson.Gson;

/**
 * @description: 常量类
 * @author: wxp
 * @time: 2022/4/8 22:30
 */
public class CommonConstants {
    /**
     * json转化工具类
     */
    public static final Gson GSON = new Gson();
    /**
     * 初始化加载消费端配置文件的目录
     */
    public static final String INIT_PROP_DIR = "consumer-config";
}
